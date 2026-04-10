package at.azawat.kbrelay.input

import at.azawat.kbrelay.mixin.KeyboardHandlerAccessor
import at.azawat.kbrelay.network.KeyMessage
import java.util.concurrent.ConcurrentLinkedQueue
import net.minecraft.client.Minecraft
import net.minecraft.client.input.KeyEvent
import org.lwjgl.glfw.GLFW

class InputHandler {
    private val queue = ConcurrentLinkedQueue<KeyMessage>()
    private val heldKeys = mutableSetOf<Int>()

    fun enqueue(msg: KeyMessage) {
        queue.add(msg)
    }

    fun releaseAll() {
        queue.add(KeyMessage("release_all"))
    }

    fun processTick(client: Minecraft) {
        val window = client.window.handle()
        val keyboard = client.keyboardHandler as KeyboardHandlerAccessor

        loop@ while (true) {
            val msg = queue.poll() ?: break
            when (msg.type) {
                "release_all" -> {
                    for (key in heldKeys) {
                        keyboard.invokeKeyPress(window, GLFW.GLFW_RELEASE, KeyEvent(key, 0, 0))
                    }
                    heldKeys.clear()
                }
                "key_down" -> {
                    val glfw = glfwKey(msg.key ?: continue@loop) ?: continue@loop
                    if (heldKeys.contains(glfw)) continue@loop
                    heldKeys.add(glfw)
                    keyboard.invokeKeyPress(window, GLFW.GLFW_PRESS, KeyEvent(glfw, 0, 0))
                }
                "key_up" -> {
                    val glfw = glfwKey(msg.key ?: continue@loop) ?: continue@loop
                    heldKeys.remove(glfw)
                    keyboard.invokeKeyPress(window, GLFW.GLFW_RELEASE, KeyEvent(glfw, 0, 0))
                }
            }
        }
    }
}
