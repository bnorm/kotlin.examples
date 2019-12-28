package coroutines.syntax

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


//


//


//


//


//


//


//


//


//


//


fun helloWorld() {
  GlobalScope.launch {
    // launch new coroutine in background and continue
    delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
    println("World!") // print after delay
  }
  println("Hello,") // main thread continues while coroutine is delayed
  Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
}


//


//


//


//


//


//


//


//


//


//


fun lightWeight() = runBlocking<Unit> {
  println(measureTimeMillis {
    val jobs = List(100_000) {
      // launch a lot of coroutines and list their jobs
      launch {
        delay(1000L)
        print(".")
      }
    }
    jobs.forEach { it.join() } // wait for all jobs to complete
    println()
  })
}


//


//


//


//


//


//


//


//


//


//


//


suspend fun doSomethingUsefulOne(): Int {
  delay(1000L) // pretend we are doing something useful here
  return 13
}

suspend fun doSomethingUsefulTwo(): Int {
  delay(1000L) // pretend we are doing something useful here, too
  return 29
}

fun sync() = runBlocking<Unit> {
  val time = measureTimeMillis {
    val one = doSomethingUsefulOne()
    val two = doSomethingUsefulTwo()
    val answer = one + two
    println("The answer is $answer")
  }
  println("Completed in $time ms")
}

fun async() = runBlocking<Unit> {
  val time = measureTimeMillis {
    coroutineScope {
      val one = async { doSomethingUsefulOne() }
      val two = async { doSomethingUsefulTwo() }
      val answer = one.await() + two.await()
      println("The answer is $answer")
    }
  }
  println("Completed in $time ms")
}
