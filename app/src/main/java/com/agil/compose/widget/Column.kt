package com.agil.compose.widget

import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.agil.compose.foundation.Modifier

class Column(modifier: Modifier) : LinearNode(modifier) {

    override fun createAndroidView(): View {
        val view = super.createAndroidView()
        (view as LinearLayout).orientation = LinearLayout.VERTICAL
        return view
    }

}