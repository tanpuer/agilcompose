package com.agil.compose.widget

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import com.agil.compose.ComposeApplication
import com.agil.compose.core.ComposeAndroidNode
import com.agil.compose.foundation.Modifier
import com.bumptech.glide.Glide

class ImageNode(modifier: Modifier) : ComposeAndroidNode(modifier) {

    var source: Any? = null
        set(value) {
            field = value
            val ctx = ComposeApplication.getContext()
            Glide.with(ctx).load(field).into(view as ImageView)
        }
        get() {
            throw IllegalAccessException()
        }

    var tintColor: String? = null
        set(value) {
            field = value
            if (tintColor.isNullOrEmpty()) {
                return
            }
            (view as ImageView).setColorFilter(Color.parseColor(tintColor))
        }

    override fun createAndroidView(): View {
        val ctx = ComposeApplication.getContext()
        return ImageView(ctx)
    }

}