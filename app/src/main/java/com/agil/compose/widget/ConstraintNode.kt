package com.agil.compose.widget

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.agil.compose.ComposeApplication
import com.agil.compose.core.ComposeAndroidNode
import com.agil.compose.foundation.Modifier

class ConstraintNode(modifier: Modifier) : ComposeAndroidNode(modifier) {

    override fun createAndroidView(): View {
        val ctx = ComposeApplication.getContext()
        return ConstraintLayout(ctx)
    }

}