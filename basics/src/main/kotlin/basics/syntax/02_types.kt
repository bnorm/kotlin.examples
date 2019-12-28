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
 * 1. The different types of the defined local variables
 */
fun main() {
  var first: String = "BRIAN"
  var last: String? = "NORMAN"

//   first = null
//   last = null
//   first = last
//   last = first

//   first.toLowerCase()
//   val something = last?.toLowerCase() ?: ""
//   if (last != null) {
//     last.toLowerCase()
//   }
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
 * 1. Any? is the super-type of every class
 */
fun name() = "Brian Norman"

val anything: Any? = name()


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
 * 1. Nothing is the sub-type of every class
 * 2. No return required
 */
fun loopForever(): Nothing {
  while (true) {
    // Hah, hah!
  }
}

val something: String = loopForever()

fun why(something: Any) {
//  val str: String = return
//  val str = something as? String ?: return
//  val str = something as? String ?: throw Exception("")
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


