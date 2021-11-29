package miin.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import miin.learning.CoroutinesContext.TestDispatchers
import miin.learning.CoroutinesContext.TestWithContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TestDispatchers.runMyFirstCoroutines()
        println("----------")
        TestWithContext.testWithContext()
    }
}