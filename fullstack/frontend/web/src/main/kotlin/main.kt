import com.bnorm.example.todo.client.TodoClient
import com.bnorm.example.todo.client.createClient
import com.bnorm.example.todo.web.app
import kotlinext.js.require
import kotlinext.js.requireAll
import react.dom.render
import kotlin.browser.document

fun main() {
  val client = TodoClient.createClient("/api/v1")

  requireAll(require.context("/", true, js("/\\.css$/")))

  render(document.getElementById("root")) {
    app(client)
  }
}
