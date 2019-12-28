package coroutines.flow

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow


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


suspend fun helloWorld() {
  flow {
    emit("Hello")
    emit("World")
  }.collect {
    println(it)
  }
}
