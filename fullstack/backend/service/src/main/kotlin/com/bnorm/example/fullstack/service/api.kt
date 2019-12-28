package com.bnorm.example.fullstack.service

import com.bnorm.example.fullstack.model.TodoPrototype
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.http.content.defaultResource
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.post
import io.ktor.routing.route
import io.ktor.routing.routing

@Location("/{id}")
data class ById(val id: Int)

@Location("")
data class Todos(
  val page: Long = 0,
  val count: Long = -1
)

fun Application.api() {
  routing {
    static("/") {
      resources("fullstack-web")
      defaultResource("fullstack-web/index.html")
    }

    route("/api/v1") {
      route("todo") {
        post {
          val prototype = call.receive<TodoPrototype>()
          call.respond(TODO())
        }
        get<Todos> { request ->
          call.respond(TODO())
        }
        get<ById> { request ->
          call.respond(TODO())
        }
      }
    }
  }
}
