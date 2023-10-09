package com.agil.compose.widget

import android.view.View
import android.widget.TextView
import com.agil.compose.ComposeApplication
import com.agil.compose.core.ComposeAndroidNode
import com.agil.compose.foundation.Modifier

class TextNode(modifier: Modifier) : ComposeAndroidNode(modifier) {

    var content: String = ""
        set(text) {
            field = text
            (view as TextView).text = field
        }
        get() {
            throw IllegalAccessException()
        }

    override fun createAndroidView(): View {
        val ctx = ComposeApplication.getContext()
        return TextView(ctx)
    }

}