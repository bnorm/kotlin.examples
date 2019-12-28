package basics.syntax

/**
 * Things to observe:
 * 0. No semicolons!
 * 1. Top level functions and variables
 * 2. `fun` keyword
 * 3. Type is listed after the variable name
 * 4. `void` keyword is not needed
 * 5. `val` keyword for final variables, `var` for non-final
 * 6. No type listed for greeting, inferred from assignment
 * 7. String templating for print statement
 */
fun main(args: Array<String>) {
  val greeting = "Hello"
  println("$greeting, $name")
}

var name: String = "World"
