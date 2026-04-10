package at.azawat.kbrelay

import com.google.gson.Gson
import net.fabricmc.loader.api.FabricLoader
import java.io.File

object Config {
    private val gson = Gson()
    private val configFile: File
        get() = FabricLoader.getInstance().configDir.resolve("kbrelay.json").toFile()

    private data class Data(val port: Int = DEFAULT_PORT)

    const val DEFAULT_PORT = 25560
    var port: Int = DEFAULT_PORT
        private set

    fun load() {
        if (!configFile.exists()) return
        try {
            port = gson.fromJson(configFile.readText(), Data::class.java).port
        } catch (_: Exception) {
            port = DEFAULT_PORT
        }
    }

    fun savePort(newPort: Int) {
        port = newPort
        configFile.writeText(gson.toJson(Data(newPort)))
    }
}
