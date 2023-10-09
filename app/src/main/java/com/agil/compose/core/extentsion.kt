package com.agil.compose.core

import android.content.res.Resources
import android.widget.Toast
import com.agil.compose.ComposeApplication

fun MutableList<ComposeAndroidNode>.remove(index: Int, count: Int) {
    if (count == 1) {
        removeAt(index)
    } else {
        subList(index, index + count).clear()
    }
}

fun MutableList<ComposeAndroidNode>.move(from: Int, to: Int, count: Int) {
    val dest = if (from > to) to else to - count
    if (count == 1) {
        if (from == to + 1 || from == to - 1) {
            // Adjacent elements, perform swap to avoid backing array manipulations.
            val fromEl = get(from)
            val toEl = set(to, fromEl)
            set(from, toEl)
        } else {
            val fromEl = removeAt(from)
            add(dest, fromEl)
        }
    } else {
        val subView = subList(from, from + count)
        val subCopy = subView.toMutableList()
        subView.clear()
        addAll(dest, subCopy)
    }
}

fun Int.dp2px(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}

fun Int.px2dp(): Int {
    return (this / Resources.getSystem().displayMetrics.density).toInt()
}

fun toast(content: String) {
    Toast.makeText(ComposeApplication.getContext(), content, Toast.LENGTH_SHORT).show()
}