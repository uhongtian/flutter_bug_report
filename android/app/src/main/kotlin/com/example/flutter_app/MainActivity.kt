package com.example.bug

import io.flutter.embedding.android.FlutterActivity

class MainActivity: FlutterActivity() {

    override fun getCachedEngineId(): String {
        return FlutterEngineHolder.FLUTTER_CACHE_ENGINE_ID
    }

    override fun shouldDestroyEngineWithHost(): Boolean {
        return false
    }

}
