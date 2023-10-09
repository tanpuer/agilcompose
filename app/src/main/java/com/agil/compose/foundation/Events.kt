package com.agil.compose.foundation

import android.view.View

fun Modifier.onPress(callback: (view: View) -> Unit): Modifier {
    events["onPress"] = callback as (Any) -> Unit
    return this
}