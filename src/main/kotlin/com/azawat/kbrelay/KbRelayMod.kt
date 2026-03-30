package com.azawat.kbrelay

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import org.slf4j.LoggerFactory

object KbRelayMod : ClientModInitializer {
    val logger = LoggerFactory.getLogger("kbrelay")
    val inputHandler = InputHandler()

    override fun onInitializeClient() {
        logger.info("KBRelay starting...")
        InputServer(inputHandler).start()
        ClientTickEvents.END_CLIENT_TICK.register { client ->
            inputHandler.processTick(client)
        }
        logger.info("KBRelay ready on :25560")
    }
}
