package coroutines.syntax


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


fun generator() {
  val fibonacci = sequence {
    var last = 0
    var next = 1

    yield(last)
    while (true) {
      yield(next)

      val tmp = next
      next += last
      last = tmp
    }
  }
}
