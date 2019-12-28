import com.bnorm.example.fullstack.client.FullstackClient
import com.bnorm.example.fullstack.client.createClient
import com.bnorm.example.fullstack.web.app
import kotlinext.js.require
import kotlinext.js.requireAll
import react.dom.render
import kotlin.browser.document

fun main() {
  val client = FullstackClient.createClient("/api/v1")

  requireAll(require.context("/", true, js("/\\.css$/")))

  render(document.getElementById("root")) {
    app(client)
  }
}
