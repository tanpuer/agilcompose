package com.agil.compose

import android.app.Application
import android.content.Context

class ComposeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        mInstance = this
    }

    companion object {
        private lateinit var mInstance: ComposeApplication

        fun getContext(): Context {
            return mInstance
        }
    }
}