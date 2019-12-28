package basics.syntax


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


/**
 * Things to observe:
 * 1. Function types supported by the language
 * 2. Lambda notation
 */
val lambda: (Any) -> String = { obj: Any ->
  obj.toString()
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


/**
 * Things to observe:
 * 1. Function as parameter -> higher-order function
 * 2. Use function just be appending parentheses
 * 3. The multiple ways of calling a higher-order function
 */
fun mapToString(list: Iterable<Any>, transformer: (Any) -> String): List<String> {
  val destination = ArrayList<String>()
  for (value in list) {
    destination.add(transformer(value))
  }
  return destination
}

fun useMapToString() {
  val values = listOf(1, 2, 3, 4)

  // All equivalent
  mapToString(values, { obj: Any -> obj.toString() })
  mapToString(values, { obj -> obj.toString() })
  mapToString(values, { it.toString() })
  mapToString(values) { it.toString() }

  mapToString(values) {
    it.toString()
  }

  mapToString(values, Any::toString)
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


/**
 * Things to observe:
 * 1. Notation for an **extension** function
 * 2. Access to `List<String>` is through `this`
 * 3. Extension functions only have public access
 */
fun List<Int>.skip(n: Int): List<Int> {
  if (n >= this.size) return emptyList()

  val list = mutableListOf(this.size - n)
  for (item in this.listIterator(this.size - n))
    list.add(item)

  return list
}

fun useSkip() {
  val values = listOf(1, 2, 3, 4)
  println(values.skip(2))

//  val strings = listOf("a", "b", "c")
//  println(strings.skip(2))
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


/**
 * Things to observe:
 * 1. Notation for a generic function
 * 2. Extension functions are resolved statically
 * 3. Function marked as `inline`?
 */
inline fun <T> List<T>.skipWhile(predicate: (T) -> Boolean): List<T> {
  val iter = listIterator()
  for (item in iter) {
    if (!predicate(item)) {
      if (iter.hasPrevious()) iter.previous()
      break
    }
  }

  val list = mutableListOf<T>()
  for (item in iter) {
    list.add(item)
  }

  return list
}

fun useSkipWhile() {
  val values = listOf(1, 2, 3, 4)
  println(values.skipWhile { it <= 2 })
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


/**
 * Things to observe:
 * 1. Notation for lambda-with-receiver as parameter
 * 2. Function marked as `infix`?
 */
infix fun <T> T.validate(predicate: T.() -> Boolean): T? {
  return if (predicate(this)) this else null
}

fun useMaybe() {
  val value = 41

  // Equivalent
  println(value.validate { this >= 42 })
  println(value validate { this >= 42 })
  //           ^ - Where's the '.'?
}
