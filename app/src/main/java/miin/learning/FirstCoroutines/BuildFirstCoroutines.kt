package miin.learning.FirstCoroutines

import kotlinx.coroutines.runBlocking

/*fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("Hello")
    }

    println("World")
    Thread.sleep(2000L)
}*/

/*fun main() {
    runBlocking {
        delay(1000L)
        println("Hello")
        delay(1000L)
        println("Coroutines")
    }
}*/

fun main() {
    val start = System.currentTimeMillis()
    runBlocking {
        repeat(1_000_000) {
            println("Hello Coroutines")
        }
    }
    val end = System.currentTimeMillis()
    println("Time = ${end - start}ms")
}
