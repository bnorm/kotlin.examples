package coroutines.syntax

val fibonacci = iterator {
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

println(fibonacci.next())
println(fibonacci.next())
println(fibonacci.next())
println(fibonacci.next())
println(fibonacci.next())
println(fibonacci.next())
println(fibonacci.next())
println(fibonacci.next())
println(fibonacci.next())
println(fibonacci.next())
