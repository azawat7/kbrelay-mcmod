package com.azawat.kbrelay

import com.azawat.kbrelay.mixin.KeyboardHandlerAccessor
import net.minecraft.client.Minecraft
import net.minecraft.client.input.KeyEvent
import org.lwjgl.glfw.GLFW
import java.util.concurrent.ConcurrentLinkedQueue

class InputHandler {
    private val queue = ConcurrentLinkedQueue<KeyMessage>()
    private val heldKeys = mutableSetOf<Int>()

    fun enqueue(msg: KeyMessage) { queue.add(msg) }
    fun releaseAll() { queue.add(KeyMessage("release_all")) }

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

    private fun glfwKey(key: String): Int? = when (key) {
        "W"           -> GLFW.GLFW_KEY_W
        "A"           -> GLFW.GLFW_KEY_A
        "S"           -> GLFW.GLFW_KEY_S
        "D"           -> GLFW.GLFW_KEY_D
        "Space"       -> GLFW.GLFW_KEY_SPACE
        "LeftShift"   -> GLFW.GLFW_KEY_LEFT_SHIFT
        "LeftControl" -> GLFW.GLFW_KEY_LEFT_CONTROL
        "E"           -> GLFW.GLFW_KEY_E
        "Q"           -> GLFW.GLFW_KEY_Q
        "F"           -> GLFW.GLFW_KEY_F
        "Escape"      -> GLFW.GLFW_KEY_ESCAPE
        "D1", "1"     -> GLFW.GLFW_KEY_1
        "D2", "2"     -> GLFW.GLFW_KEY_2
        "D3", "3"     -> GLFW.GLFW_KEY_3
        "D4", "4"     -> GLFW.GLFW_KEY_4
        "D5", "5"     -> GLFW.GLFW_KEY_5
        "D6", "6"     -> GLFW.GLFW_KEY_6
        "D7", "7"     -> GLFW.GLFW_KEY_7
        "D8", "8"     -> GLFW.GLFW_KEY_8
        "D9", "9"     -> GLFW.GLFW_KEY_9
        "NumPad0", "Insert"    -> GLFW.GLFW_KEY_KP_0
        "NumPadDecimal", "Delete" -> GLFW.GLFW_KEY_KP_DECIMAL
        "NumPadEnter", "Return", "Enter" -> GLFW.GLFW_KEY_KP_ENTER
        else          -> null
    }
}
