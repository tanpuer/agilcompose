package com.agil.compose.foundation

fun Modifier.padding(margin: Int): Modifier {
    styles["padding"] = intArrayOf(margin, margin, margin, margin)
    return this
}

fun Modifier.paddingLeft(margin: Int): Modifier {
    val paddings = styles["padding"] as? IntArray ?: IntArray(4)
    paddings[0] = margin
    styles["padding"] = paddings
    return this
}

fun Modifier.paddingTop(margin: Int): Modifier {
    val paddings = styles["padding"] as? IntArray ?: IntArray(4)
    paddings[1] = margin
    styles["padding"] = paddings
    return this
}

fun Modifier.paddingRight(margin: Int): Modifier {
    val paddings = styles["padding"] as? IntArray ?: IntArray(4)
    paddings[2] = margin
    styles["padding"] = paddings
    return this
}

fun Modifier.paddingBottom(margin: Int): Modifier {
    val paddings = styles["padding"] as? IntArray ?: IntArray(4)
    paddings[3] = margin
    styles["padding"] = paddings
    return this
}