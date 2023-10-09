package com.agil.compose.foundation

import android.graphics.Color

fun Modifier.textColor(color: String): Modifier {
    styles["textColor"] = Color.parseColor(color)
    return this
}

fun Modifier.textSize(size: Int): Modifier {
    styles["textSize"] = size
    return this
}