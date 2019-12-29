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


fun html(block: Html.() -> Unit): String {
  val builder = StringBuilder()
  builder.withTag("html") { Html(builder).block() }
  return builder.toString()
}

fun main() {
  val html = html {
    head {}
    body {
      table {
        tr {
          // loops!
          repeat(5) {
            td {}
          }
        }
      }
    }
  }
  println(html)
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


@DslMarker
annotation class HtmlDsl

@HtmlDsl
class Html(
  private val builder: StringBuilder
) {
  fun head(block: Head.() -> Unit) {
    builder.withTag("head") { Head(builder).block() }
  }

  fun body(block: Body.() -> Unit) {
    builder.withTag("body") { Body(builder).block() }
  }
}

@HtmlDsl
class Head(
  private val builder: StringBuilder
)

@HtmlDsl
class Body(
  private val builder: StringBuilder
) {
  fun table(block: Table.() -> Unit) {
    builder.withTag("table") { Table(builder).block() }
  }
}

@HtmlDsl
class Table(
  private val builder: StringBuilder
) {
  fun tr(block: Tr.() -> Unit) {
    builder.withTag("tr") { Tr(builder).block() }
  }
}

@HtmlDsl
class Tr(
  private val builder: StringBuilder
) {
  fun td(block: Td.() -> Unit) {
    builder.withTag("td") { Td(builder).block() }
  }
}

@HtmlDsl
class Td(
  private val builder: StringBuilder
)

inline fun StringBuilder.withTag(tag: String, block: () -> Unit) {
  append("<$tag>\n")
  block()
  append("</$tag>\n")
}
