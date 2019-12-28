package basics.dsl


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


fun html(block: Html.() -> Unit): Unit = TODO()

fun main() {
  html {
    head {}
    body {
      table {
        head {} // is this valid?
        tr {
          // loops!
          repeat(5) {
            td {}
          }
        }
      }
    }
  }
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


//@DslMarker
annotation class HtmlDsl

@HtmlDsl
interface Html {
  fun head(block: Head.() -> Unit)
  fun body(block: Body.() -> Unit)
}

@HtmlDsl
interface Head

@HtmlDsl
interface Body {
  fun table(block: Table.() -> Unit)
}

@HtmlDsl
interface Table {
  fun tr(block: Tr.() -> Unit)
}

@HtmlDsl
interface Tr {
  fun td(block: Td.() -> Unit)
}

@HtmlDsl
interface Td
