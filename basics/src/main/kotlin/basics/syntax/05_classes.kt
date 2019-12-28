package basics.syntax












/**
 * Things to observe:
 * 1. Looks like a function signature because it's actually the primary constructor
 * 2. Class properties can be defined by the primary constructor
 * 3. Default scope is public
 * 4. No explicit getters and setters, field style access, unless defined explicitly
 * 5. Can define additional properties and customize getter
 * 6. Properties can be **delegated** to special classes
 */
class Employee(
  val firstName: String,
  val lastName: String,
  var email: String,
  private var socialSecurity: String
) {
  val fullName: String by lazy { "$firstName $lastName"}

  val emailHeader: String
    get() = "$fullName <$email>"

  fun validateSocial(): Boolean = socialSecurity.isNotBlank()
}

fun main(args: Array<String>) {
  val brian = Employee("Brian", "Norman", "Brian.Norman@Dell.com", "")

  println(brian.emailHeader)

  // See ya, Dell/EMC!
  brian.email = "brian_norman@atavium.com"

  println(brian.emailHeader)

  brian.validateSocial()
}
























/**
 * Things to observe:
 * 1. No class body
 * 2. `data` class -> ...?
 */
data class Person(
  val firstName: String,
  val lastName: String,
  var email: String?
)

fun usePerson(args: Array<String>) {
  val (firstName, lastName, email) = Person("Brian", "Norman", "brian_norman@atavium.com")
}
























/**
 * Things to observe:
 * 1. Abstract class definition
 * 2. Interface class definition
 * 3. Generic class definition
 * 4. `in` and `out` keywords are covariance and contravariance
 * 5. `override` is a keyword
 * 6. Assignment of covariant and contravariant classes
 */

abstract class Producer<out T> {
  abstract fun produce(): T
}

interface Consumer<in T> {
  fun consume(t: T)
}

class Pipe<T>(private var value: T) : Producer<T>(), Consumer<T> {
  override fun produce() = value
  override fun consume(t: T) { value = t }
}

fun usePipe(args: Array<String>) {
  val pipe: Pipe<CharSequence> = Pipe("1")
  val producer: Producer<Any> = pipe
  val consumer: Consumer<String> = pipe
}































//
