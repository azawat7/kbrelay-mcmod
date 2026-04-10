package at.azawat.kbrelay

import com.mojang.brigadier.arguments.IntegerArgumentType
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback
import net.minecraft.network.chat.Component

object Commands {
    fun register() {
        ClientCommandRegistrationCallback.EVENT.register { dispatcher, _ ->
            dispatcher.register(
                literal("kbrelay")
                    .then(
                        literal("info").executes { ctx ->
                            ctx.source.sendFeedback(
                                Component.literal("KBRelay listening on port ${Config.port}")
                            )
                            1
                        }
                    )
                    .then(
                        literal("port")
                            .then(
                                argument("port", IntegerArgumentType.integer(1, 65535)).executes {
                                    ctx ->
                                    val newPort = IntegerArgumentType.getInteger(ctx, "port")
                                    Config.savePort(newPort)
                                    KbRelayMod.inputServer.restart(newPort)
                                    ctx.source.sendFeedback(
                                        Component.literal("KBRelay port changed to $newPort")
                                    )
                                    1
                                }
                            )
                    )
                    .then(
                        literal("reset").executes { ctx ->
                            Config.savePort(Config.DEFAULT_PORT)
                            KbRelayMod.inputServer.restart(Config.DEFAULT_PORT)
                            ctx.source.sendFeedback(
                                Component.literal("KBRelay port reset to ${Config.DEFAULT_PORT}")
                            )
                            1
                        }
                    )
            )
        }
    }
}
