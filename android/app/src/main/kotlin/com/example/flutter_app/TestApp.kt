package com.example.bug

import android.app.Application

/**
 *
 * @author youht
 * @date 9/22/21
 */
class TestApp: Application() {

    override fun onCreate() {
        super.onCreate()
        FlutterEngineHolder.init(this)
    }

}