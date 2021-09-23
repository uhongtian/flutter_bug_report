package com.example.bug

import android.content.Context
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

/**
 *
 * @author youht
 * @date 9/22/21
 */
object FlutterEngineHolder {

    const val FLUTTER_CACHE_ENGINE_ID = "flutter_cache_engine_id"
    private const val DEFAULT_DART_ENTRYPOINT = "main"
    private const val DEFAULT_INITIAL_ROUTE = "/"

    fun init(context: Context): FlutterEngine {
        var engine = FlutterEngineCache.getInstance().get(FLUTTER_CACHE_ENGINE_ID)
        if (engine != null) {
            return engine
        }
        engine = FlutterEngine(context.applicationContext)
        FlutterEngineCache.getInstance().put(FLUTTER_CACHE_ENGINE_ID, engine)
        if (!engine.dartExecutor.isExecutingDart) {
            engine.navigationChannel.setInitialRoute(DEFAULT_INITIAL_ROUTE)
            engine.dartExecutor.executeDartEntrypoint(
                    DartExecutor.DartEntrypoint(
                            FlutterInjector.instance().flutterLoader().findAppBundlePath(),
                            DEFAULT_DART_ENTRYPOINT))
        }
        engine.platformViewsController.registry
                .registerViewFactory("test_view_type", NativeViewFactory())
        return engine
    }

}