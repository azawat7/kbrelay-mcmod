package at.azawat.kbrelay

import at.azawat.kbrelay.input.InputHandler
import at.azawat.kbrelay.network.InputServer
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import org.slf4j.LoggerFactory

object KbRelayMod : ClientModInitializer {
    val logger = LoggerFactory.getLogger("kbrelay")
    val inputHandler = InputHandler()
    lateinit var inputServer: InputServer

    override fun onInitializeClient() {
        Config.load()
        logger.info("KBRelay starting on port ${Config.port}...")
        inputServer = InputServer(inputHandler)
        inputServer.start()
        Commands.register()
        ClientTickEvents.END_CLIENT_TICK.register { client -> inputHandler.processTick(client) }
        logger.info("KBRelay ready on :${Config.port}")
    }
}
