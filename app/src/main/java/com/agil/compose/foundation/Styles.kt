package com.agil.compose.foundation

import android.view.ViewGroup

fun Modifier.size(width: Int, height: Int): Modifier {
    styles["width"] = width
    styles["height"] = height
    return this
}

fun Modifier.zIndex(index: Int): Modifier {
    styles["zIndex"] = index
    return this
}

fun Modifier.cornerRadius(index: Int): Modifier {
    styles["cornerRadius"] = index
    return this
}

fun Modifier.alpha(alpha: Float): Modifier {
    styles["alpha"] = alpha
    return this
}

fun Modifier.gravity(gravity: Int): Modifier {
    styles["gravity"] = gravity
    return this
}

fun Modifier.weight(weight: Int): Modifier {
    styles["weight"] = weight
    return this
}

fun Modifier.fillMaxSize(): Modifier {
    styles["width"] = ViewGroup.LayoutParams.MATCH_PARENT
    styles["height"] = ViewGroup.LayoutParams.MATCH_PARENT
    return this
}

fun Modifier.fillWidth(): Modifier {
    styles["width"] = ViewGroup.LayoutParams.MATCH_PARENT
    return this
}

fun Modifier.fillHeight(): Modifier {
    styles["height"] = ViewGroup.LayoutParams.MATCH_PARENT
    return this
}

fun Modifier.wrapSize(): Modifier {
    styles["width"] = ViewGroup.LayoutParams.WRAP_CONTENT
    styles["height"] = ViewGroup.LayoutParams.WRAP_CONTENT
    return this
}
