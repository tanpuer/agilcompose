package com.agil.compose.foundation

import com.agil.compose.core.dp2px

fun Modifier.margin(margin: Int): Modifier {
    val value = margin.dp2px()
    styles["margin"] = intArrayOf(value, value, value, value)
    return this
}

fun Modifier.marginLeft(margin: Int): Modifier {
    val margins = styles["margin"] as? IntArray ?: IntArray(4)
    margins[0] = margin.dp2px()
    styles["margin"] = margins
    return this
}

fun Modifier.marginTop(margin: Int): Modifier {
    val margins = styles["margin"] as? IntArray ?: IntArray(4)
    margins[1] = margin.dp2px()
    styles["margin"] = margins
    return this
}

fun Modifier.marginRight(margin: Int): Modifier {
    val margins = styles["margin"] as? IntArray ?: IntArray(4)
    margins[2] = margin.dp2px()
    styles["margin"] = margins
    return this
}

fun Modifier.marginBottom(margin: Int): Modifier {
    val margins = styles["margin"] as? IntArray ?: IntArray(4)
    margins[3] = margin.dp2px()
    styles["margin"] = margins
    return this
}