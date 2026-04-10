package at.azawat.kbrelay

import org.lwjgl.glfw.GLFW

fun glfwKey(key: String): Int? = when (key) {
    "A" -> GLFW.GLFW_KEY_A
    "B" -> GLFW.GLFW_KEY_B
    "C" -> GLFW.GLFW_KEY_C
    "D" -> GLFW.GLFW_KEY_D
    "E" -> GLFW.GLFW_KEY_E
    "F" -> GLFW.GLFW_KEY_F
    "G" -> GLFW.GLFW_KEY_G
    "H" -> GLFW.GLFW_KEY_H
    "I" -> GLFW.GLFW_KEY_I
    "J" -> GLFW.GLFW_KEY_J
    "K" -> GLFW.GLFW_KEY_K
    "L" -> GLFW.GLFW_KEY_L
    "M" -> GLFW.GLFW_KEY_M
    "N" -> GLFW.GLFW_KEY_N
    "O" -> GLFW.GLFW_KEY_O
    "P" -> GLFW.GLFW_KEY_P
    "Q" -> GLFW.GLFW_KEY_Q
    "R" -> GLFW.GLFW_KEY_R
    "S" -> GLFW.GLFW_KEY_S
    "T" -> GLFW.GLFW_KEY_T
    "U" -> GLFW.GLFW_KEY_U
    "V" -> GLFW.GLFW_KEY_V
    "W" -> GLFW.GLFW_KEY_W
    "X" -> GLFW.GLFW_KEY_X
    "Y" -> GLFW.GLFW_KEY_Y
    "Z" -> GLFW.GLFW_KEY_Z

    "One"   -> GLFW.GLFW_KEY_1
    "Two"   -> GLFW.GLFW_KEY_2
    "Three" -> GLFW.GLFW_KEY_3
    "Four"  -> GLFW.GLFW_KEY_4
    "Five"  -> GLFW.GLFW_KEY_5
    "Six"   -> GLFW.GLFW_KEY_6
    "Seven" -> GLFW.GLFW_KEY_7
    "Eight" -> GLFW.GLFW_KEY_8
    "Nine"  -> GLFW.GLFW_KEY_9
    "Zero"  -> GLFW.GLFW_KEY_0

    "F1"  -> GLFW.GLFW_KEY_F1
    "F2"  -> GLFW.GLFW_KEY_F2
    "F3"  -> GLFW.GLFW_KEY_F3
    "F4"  -> GLFW.GLFW_KEY_F4
    "F5"  -> GLFW.GLFW_KEY_F5
    "F6"  -> GLFW.GLFW_KEY_F6
    "F7"  -> GLFW.GLFW_KEY_F7
    "F8"  -> GLFW.GLFW_KEY_F8
    "F9"  -> GLFW.GLFW_KEY_F9
    "F10" -> GLFW.GLFW_KEY_F10
    "F11" -> GLFW.GLFW_KEY_F11
    "F12" -> GLFW.GLFW_KEY_F12

    "LeftShift"       -> GLFW.GLFW_KEY_LEFT_SHIFT
    "RightShift"      -> GLFW.GLFW_KEY_RIGHT_SHIFT
    "Control"         -> GLFW.GLFW_KEY_LEFT_CONTROL
    "Alt"             -> GLFW.GLFW_KEY_LEFT_ALT
    "LeftWindowsKey"  -> GLFW.GLFW_KEY_LEFT_SUPER
    "RightWindowsKey" -> GLFW.GLFW_KEY_RIGHT_SUPER
    "Menu"            -> GLFW.GLFW_KEY_MENU

    "Escape"     -> GLFW.GLFW_KEY_ESCAPE
    "Enter"      -> GLFW.GLFW_KEY_ENTER
    "Backspace"  -> GLFW.GLFW_KEY_BACKSPACE
    "Tab"        -> GLFW.GLFW_KEY_TAB
    "Space"      -> GLFW.GLFW_KEY_SPACE
    "CapsLock"   -> GLFW.GLFW_KEY_CAPS_LOCK
    "NumLock"    -> GLFW.GLFW_KEY_NUM_LOCK
    "ScrollLock" -> GLFW.GLFW_KEY_SCROLL_LOCK
    "PrintScreen" -> GLFW.GLFW_KEY_PRINT_SCREEN

    "Up"       -> GLFW.GLFW_KEY_UP
    "Down"     -> GLFW.GLFW_KEY_DOWN
    "Left"     -> GLFW.GLFW_KEY_LEFT
    "Right"    -> GLFW.GLFW_KEY_RIGHT
    "Home"     -> GLFW.GLFW_KEY_HOME
    "End"      -> GLFW.GLFW_KEY_END
    "PageUp"   -> GLFW.GLFW_KEY_PAGE_UP
    "PageDown" -> GLFW.GLFW_KEY_PAGE_DOWN
    "Insert"   -> GLFW.GLFW_KEY_INSERT
    "Delete"   -> GLFW.GLFW_KEY_DELETE

    "Dash"              -> GLFW.GLFW_KEY_MINUS
    "Equals"            -> GLFW.GLFW_KEY_EQUAL
    "OpenBracketBrace"  -> GLFW.GLFW_KEY_LEFT_BRACKET
    "CloseBracketBrace" -> GLFW.GLFW_KEY_RIGHT_BRACKET
    "Backslash"         -> GLFW.GLFW_KEY_BACKSLASH
    "Semicolon"         -> GLFW.GLFW_KEY_SEMICOLON
    "Apostrophe"        -> GLFW.GLFW_KEY_APOSTROPHE
    "Tilde"             -> GLFW.GLFW_KEY_GRAVE_ACCENT
    "Comma"             -> GLFW.GLFW_KEY_COMMA
    "Dot"               -> GLFW.GLFW_KEY_PERIOD
    "Slash"             -> GLFW.GLFW_KEY_SLASH

    "Numpad0"        -> GLFW.GLFW_KEY_KP_0
    "Numpad1"        -> GLFW.GLFW_KEY_KP_1
    "Numpad2"        -> GLFW.GLFW_KEY_KP_2
    "Numpad3"        -> GLFW.GLFW_KEY_KP_3
    "Numpad4"        -> GLFW.GLFW_KEY_KP_4
    "Numpad5"        -> GLFW.GLFW_KEY_KP_5
    "Numpad6"        -> GLFW.GLFW_KEY_KP_6
    "Numpad7"        -> GLFW.GLFW_KEY_KP_7
    "Numpad8"        -> GLFW.GLFW_KEY_KP_8
    "Numpad9"        -> GLFW.GLFW_KEY_KP_9
    "NumpadEnter"    -> GLFW.GLFW_KEY_KP_ENTER
    "NumpadDelete"   -> GLFW.GLFW_KEY_KP_DECIMAL
    "NumpadPlus"     -> GLFW.GLFW_KEY_KP_ADD
    "NumpadMinus"    -> GLFW.GLFW_KEY_KP_SUBTRACT
    "NumpadAsterisk" -> GLFW.GLFW_KEY_KP_MULTIPLY
    "NumpadDivide"   -> GLFW.GLFW_KEY_KP_DIVIDE
    else             -> null
}
