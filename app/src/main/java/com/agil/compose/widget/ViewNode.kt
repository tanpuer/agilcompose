package com.agil.compose.widget

import android.view.View
import com.agil.compose.ComposeApplication
import com.agil.compose.core.ComposeAndroidNode
import com.agil.compose.foundation.Modifier

class ViewNode(modifier: Modifier) : ComposeAndroidNode(modifier) {

    override fun createAndroidView(): View {
        val ctx = ComposeApplication.getContext()
        return View(ctx)
    }

}