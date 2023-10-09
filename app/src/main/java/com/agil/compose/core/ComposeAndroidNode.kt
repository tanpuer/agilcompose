package com.agil.compose.core

import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.agil.compose.foundation.Modifier
import kotlin.UnsupportedOperationException

abstract class ComposeAndroidNode(modifier: Modifier) {

    val view: View by lazy {
        val view = createAndroidView()
        initStyles(view, modifier)
        initAttributes(view, modifier)
        initEvents(view, modifier)
        view
    }

    private val children = mutableListOf<ComposeAndroidNode>()

    open fun addChild(index: Int, child: ComposeAndroidNode) {
        children.add(index, child)
        assert(view is LinearLayout)
        if (view is LinearLayout) {
            (view as LinearLayout).addView(child.view, index)
        } else if (view is ConstraintLayout) {
            (view as ConstraintLayout).addView(child.view, index)
        } else {
            throw UnsupportedOperationException()
        }
    }

    open fun move(from: Int, to: Int, count: Int) {
        children.move(from, to, count)
        //todo
        (view as LinearLayout)
    }

    open fun remove(index: Int, count: Int) {
        children.remove(index, count)
        if (view is LinearLayout) {
            (view as LinearLayout).removeViews(index, count)
        } else if (view is ConstraintLayout) {
            (view as ConstraintLayout).removeViews(index, count)
        } else {
            throw UnsupportedOperationException()
        }
    }

    open fun clear() {
        children.clear()
        (view as ViewGroup).removeAllViews()
    }

    abstract fun createAndroidView(): View

    open fun destroyAndroidView() {}

    private fun initStyles(view: View, modifier: Modifier) {
        if (view.layoutParams == null) {
            view.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
        modifier.styles.forEach { (key, value) ->
            when (key) {
                "width" -> {
                    view.layoutParams.width = value as Int
                }

                "height" -> {
                    view.layoutParams.height = value as Int
                }

                "backgroundColor" -> {
                    view.setBackgroundColor(value as Int)
                }

                "zIndex" -> {
                    view.z = (value as Int).toFloat()
                }

                "cornerRadius" -> {

                }

                "alpha" -> {
                    view.alpha = value as Float
                }

                "textColor" -> {
                    (view as TextView).setTextColor(value as Int)
                }

                "textSize" -> {
                    (view as TextView).setTextSize(
                        TypedValue.COMPLEX_UNIT_DIP, (value as Int).toFloat()
                    )
                }

                "margin" -> {
                    val margins = value as IntArray
                    (view.layoutParams as LinearLayout.LayoutParams).setMargins(
                        margins[0], margins[1], margins[2], margins[3]
                    )
                }

                "padding" -> {
                    val paddings = value as IntArray
                    view.setPadding(paddings[0], paddings[1], paddings[2], paddings[3])
                }

                "gravity" -> {
                    (view as LinearLayout).gravity = value as Int
                }

                else -> {
                    Log.e(TAG, "Unsupported style: ${key}: $value")
                }
            }
        }
    }

    private fun initAttributes(view: View, modifier: Modifier) {
        modifier.attributes.forEach { (key, value) ->
            when (key) {

            }
        }
    }

    private fun initEvents(view: View, modifier: Modifier) {
        modifier.events.forEach { (key, value) ->
            when (key) {
                "onPress" -> {
                    view.setOnClickListener {
                        value.invoke(it)
                    }
                }

                else -> {
                    Log.e(TAG, "Unsupported event: ${key}: $value")
                }
            }
        }
    }

    companion object {
        private const val TAG = "ComposeAndroidNode"
    }

}