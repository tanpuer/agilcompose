package com.agil.compose.core

import androidx.compose.runtime.AbstractApplier

class ComposeAndroidApplier(root: ComposeAndroidNode) : AbstractApplier<ComposeAndroidNode>(root) {

    override fun insertBottomUp(index: Int, instance: ComposeAndroidNode) {
        //ignore
    }

    override fun insertTopDown(index: Int, instance: ComposeAndroidNode) {
        current.addChild(index, instance)
    }

    override fun move(from: Int, to: Int, count: Int) {
        current.move(from, to, count)
    }

    override fun onClear() {
        current.clear()
    }

    override fun remove(index: Int, count: Int) {
        current.remove(index, count)
    }

}