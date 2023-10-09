package com.agil.compose.foundation

fun Modifier.custom(key: String, value: Any): Modifier {
    attributes[key] = value
    return this
}