package com.agil.compose.foundation

import android.graphics.Color
import android.graphics.drawable.shapes.Shape

fun Modifier.backgroundColor(color: String): Modifier {
    styles["backgroundColor"] = Color.parseColor(color)
    return this
}

fun Modifier.backgroundShape(shape: Shape): Modifier {
    styles["backgroundShape"] = shape
    return this
}