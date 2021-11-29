package miin.learning.CoroutinesContext

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

/*fun main() {
    val job = GlobalScope.launch {
        delay(2000L)
        println("Hello Kotlin")
    }

    val job2 = GlobalScope.launch {
        job.join()
        delay(1000L)
        println("I'm Coroutines")
    }
    Thread.sleep(4000)
}*/

/*fun main() {
    runBlocking {
        val job = launch(Dispatchers.Default) {
            repeat(1000) {
                delay(500L)
                println("I'm sleeping $it...")
            }
        }
        delay(1500L)
        job.cancel()
        println("Cancelled Coroutines")
    }
}*/

/*fun main() {
    // Coroutines vẫn in tiếp tục
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++}...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting")
        job.cancel()
        println("main: Now I can quit")
    }
}*/

/*fun main() {
    // Coroutines vẫn in tiếp tục
    runBlocking {
        val startTime = System.currentTimeMillis()
        val job = launch(Dispatchers.Default) {
            var nextPrintTime = startTime
            var i = 0
            while (isActive) { // Thay thế điều kiện để có thể cancel cổutines
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++}...")
                    nextPrintTime += 500L
                }
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting")
        job.cancel()
        println("main: Now I can quit")
    }
}*/

/*fun main() {
    // Hàm finally sẽ chạy cuối cùng
    runBlocking {
        val job = launch {
            try {
                repeat(1000) { i ->
                    println("job: I'm sleeping $i...")
                    delay(500L)
                }
            } finally {
                // Đóng các resource trong này
                println("I'm running finally")
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting")
        job.cancel()
        println("main: Now I can quit")
    }
}*/

/*fun main() {
    // Delay bên trong finally thì coroutine có thể bị kill
    runBlocking {
        val job = launch {
            try {
                repeat(1000) { i ->
                    println("job: I'm sleeping $i...")
                    delay(500L)
                }
            } finally {
                // Đóng các resource trong này
                println("I'm running finally")
                delay(1000L)
                //Dòng này sẽ không được in bởi vì hàm delay đã chek isActive và phát hiện coroutines đã bị huỷ bỏ
                println("Print me please")
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting")
        job.cancel()
        println("main: Now I can quit")
    }
}*/

/*fun main() {
    // Dùng Noncancellable để coroutines bất tử
    runBlocking {
        val job = launch {
            try {
                repeat(1000) { i ->
                    println("job: I'm sleeping $i...")
                    delay(500L)
                }
            } finally {
                withContext(NonCancellable) {
                    println("I'm running finally")
                    delay(1000L)
                    println("I'm non-cancellable")
                }
            }
        }
        delay(1300L)
        println("main: I'm tired of waiting")
        job.cancel()
        println("main: Now I can quit")
    }
}*/

/*fun main() {
    // Sẽ bắn ra 1 exception
    runBlocking {
        withTimeout(1300L) {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
        }
    }
}*/

/*fun main() {
    // Trường hợp coroutines bị huỷ thì result sẽ là null, nếu coroutines được thực hiện hết thì result sẽ là "Done"
    runBlocking {
        val result = withTimeoutOrNull(1300L) {
            repeat(1000) { i ->
                println("I'm sleeping $i ...")
                delay(500L)
            }
            "Done"
        }
        println("Result is $result")
    }
}*/
