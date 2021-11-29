package miin.learning.CoroutinesContext

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import miin.learning.MainActivity

object TestDispatchers {
    fun runMyFirstCoroutines() {
        // Mặc định sẽ chạy trên Dispatcher.Default
        GlobalScope.launch(Dispatchers.Default) {
            Log.d(MainActivity::class.java.simpleName, "Dispatchers Default run on ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.IO) {
            Log.d(MainActivity::class.java.simpleName, "Dispatchers IO run on ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Main) {
            Log.d(MainActivity::class.java.simpleName, "Dispatchers Main run on ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Unconfined) {
            Log.d(MainActivity::class.java.simpleName, "Dispatchers Unconfined run on ${Thread.currentThread().name}")
        }

        GlobalScope.launch(newSingleThreadContext("My Thread")) {
            Log.d(MainActivity::class.java.simpleName, "run on ${Thread.currentThread().name}")
        }
    }
}