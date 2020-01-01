package com.bnorm.example.todo.service

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.application.log
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.features.StatusPages
import io.ktor.http.HttpStatusCode
import io.ktor.locations.Locations
import io.ktor.response.respond
import io.ktor.serialization.serialization
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import java.util.UUID

fun main() {
  val server = embeddedServer(Netty, 8080) {
    install(DefaultHeaders)

    install(CallLogging) {
      mdc("request.id") { UUID.randomUUID().toString().substring(0, 8) }
    }

    install(ContentNegotiation) {
      serialization()
    }

    install(Locations)

    install(StatusPages) {
      exception<NoSuchElementException> { cause ->
        log.warn("Error stewarding request", cause)
        call.respond(HttpStatusCode.NotFound, cause.message ?: "Unknown error")
      }
      exception<Throwable> { cause ->
        log.warn("Error stewarding request", cause)
        call.respond(HttpStatusCode.InternalServerError, cause.message ?: "Unknown error")
      }
    }

    api()
  }
  server.start(wait = true)
}
