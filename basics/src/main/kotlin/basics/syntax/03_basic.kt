package basics.syntax







/**
 * Things to observe:
 * 1. Function return type is list after function signature
 * 2. No primitive style `int`
 */
fun sum(a: Int, b: Int): Int {
  return a + b
}

























/**
 * Things to observe:
 * 1. Simple functions can be simplified
 */
fun multiply(a: Int, b: Int) = a * b




























/**
 * Things to observe:
 * 1. `if` is actually an expression
 */
fun max(a: Int, b: Int): Int {
  return if (a > b) a else b
}





























/**
 * Things to observe:
 * 1. `..` as range operator
 * 2. `for` loop only supports for-each style
 * 3. Index access to `List` is similar to `Array`
 */
fun max(values: List<Int>): Int? {
  var max: Int? = null
  for (i in 0..values.size - 1) {
    max =  max(max ?: Int.MIN_VALUE, values[i])
  }
  return max
}



























/**
 * Things to observe:
 * 1. `when` keyword instead of `switch`
 * 2. Instance checks use `is`
 */
fun name(obj: Any): String {
  return when (obj) {
    1 -> "One"
    "Hello" -> "Greeting"
    is Long -> "Long"
    !is String -> "Not a string"
    else -> "Unknown"
  }
}
























/**
 * Things to observe:
 * 1. Default parameters
 * 2. No `new` keyword for object instantiation
 * 3. Names of parameters can be used and reordered
 */
fun joinToString(
  list: Iterable<String>,
  separator: String = ", ",
  prefix: String = "",
  postfix: String = ""
): String {
  val buffer = StringBuffer()
  buffer.append(prefix)

  var count = 0
  for (element in list) {
    if (++count > 1) buffer.append(separator)
    buffer.append(element)
  }

  buffer.append(postfix)
  return buffer.toString()
}

fun main(args: Array<String>) {
  val names = listOf("Ed", "Marc", "Mark", "Mike")
  println(joinToString(names, prefix = "Our Founders are ", separator = " and "))
}














//
