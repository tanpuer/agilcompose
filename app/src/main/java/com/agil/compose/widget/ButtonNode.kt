package com.agil.compose.widget

import android.view.View
import android.widget.Button
import com.agil.compose.ComposeApplication
import com.agil.compose.core.ComposeAndroidNode
import com.agil.compose.foundation.Modifier

class ButtonNode(val onPress: (view: View) -> Unit, modifier: Modifier) :
    ComposeAndroidNode(modifier) {

    var content: String = ""
        set(value) {
            field = value
            (view as Button).text = value
        }
        get() {
            throw IllegalAccessException()
        }

    override fun createAndroidView(): View {
        val ctx = ComposeApplication.getContext()
        return Button(ctx).apply {
            setOnClickListener {
                onPress(this)
            }
        }
    }

}