package basics.dsl










fun html(block: Html.() -> Unit): Unit = TODO()

fun main(args: Array<String>) {
  html {
    head {
    }
    body {
      table {
        tr {
          td {}
          td {}
        }
      }
    }
  }
}


















interface Html {
  fun head(block: Head.() -> Unit)
  fun body(block: Body.() -> Unit)
}

interface Head

interface Body {
  fun table(block: Table.() -> Unit)
}

interface Table {
  fun tr(block: Tr.() -> Unit)
}

interface Tr {
  fun td(block: Td.() -> Unit)
}

interface Td



