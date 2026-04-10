package at.azawat.kbrelay.network

import at.azawat.kbrelay.Config
import at.azawat.kbrelay.KbRelayMod
import at.azawat.kbrelay.input.InputHandler
import java.net.ServerSocket
import java.net.Socket
import java.net.SocketException

class InputServer(private val handler: InputHandler) {
    @Volatile private var serverSocket: ServerSocket? = null

    fun start() = startOn(Config.port)

    fun restart(port: Int) {
        serverSocket?.close()
        startOn(port)
    }

    private fun startOn(port: Int) {
        val thread = Thread({
            try {
                val server = ServerSocket(port)
                serverSocket = server
                KbRelayMod.logger.info("KBRelay listening on :$port")
                while (!server.isClosed) {
                    try {
                        val client = server.accept()
                        KbRelayMod.logger.info("KBRelay: C# app connected from ${client.remoteSocketAddress}")
                        handleClient(client)
                    } catch (e: SocketException) {
                        if (server.isClosed) break
                        KbRelayMod.logger.error("KBRelay accept error: ${e.message}", e)
                    }
                }
            } catch (e: Exception) {
                KbRelayMod.logger.error("KBRelay server failed: ${e.message}", e)
            }
        }, "kbrelay-server")
        thread.isDaemon = true
        thread.start()
    }

    private fun handleClient(socket: Socket) {
        val thread = Thread({
            try {
                socket.use { sock ->
                    val reader = sock.getInputStream().bufferedReader()
                    var line: String?
                    while (reader.readLine().also { line = it } != null) {
                        KbRelayMod.logger.info("KBRelay recv: $line")
                        val msg = Protocol.parse(line!!)
                        if (msg == null) {
                            KbRelayMod.logger.warn("KBRelay: failed to parse: $line")
                            continue
                        }
                        when (msg.type) {
                            "key_down", "key_up" -> handler.enqueue(msg)
                            else -> KbRelayMod.logger.warn("KBRelay: unknown message type '${msg.type}'")
                        }
                    }
                    KbRelayMod.logger.info("KBRelay: readLine() returned null (client closed write end)")
                }
            } catch (e: Exception) {
                KbRelayMod.logger.warn("KBRelay: connection error: ${e::class.simpleName}: ${e.message}")
            } finally {
                KbRelayMod.logger.info("KBRelay: client handler exiting, releasing all keys")
                handler.releaseAll()
            }
        }, "kbrelay-client")
        thread.isDaemon = true
        thread.start()
    }
}
