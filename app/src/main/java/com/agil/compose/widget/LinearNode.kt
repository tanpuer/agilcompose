package com.agil.compose.widget

import android.view.View
import android.widget.LinearLayout
import com.agil.compose.ComposeApplication
import com.agil.compose.core.ComposeAndroidNode
import com.agil.compose.foundation.Modifier

abstract class LinearNode(modifier: Modifier) : ComposeAndroidNode(modifier) {

    override fun createAndroidView(): View {
        val ctx = ComposeApplication.getContext()
        return LinearLayout(ctx)
    }

}