package com.bnorm.example.fullstack.client

import kotlinx.coroutines.await
import org.w3c.fetch.RequestCredentials
import org.w3c.fetch.RequestInit
import org.w3c.fetch.SAME_ORIGIN
import kotlin.browser.window
import kotlin.js.json

open class IOException(message: String, cause: Throwable? = null) : Exception(message, cause)
open class HttpException(message: String, cause: Throwable? = null) : IOException(message, cause)

internal suspend fun request(
  method: String,
  url: String,
  body: String? = null
): String {
  val response = window.fetch(url, object : RequestInit {
    override var method: String? = method
    override var body: dynamic = body
    override var credentials: RequestCredentials? = RequestCredentials.SAME_ORIGIN
    override var headers: dynamic = json(
      "Accept" to "application/json",
      "Content-Type" to "application/json"
    )
  }).await()
  if (response.ok) {
    return response.text().await()
  } else {
    throw HttpException("${response.statusText}: ${response.text().await()}")
  }
}
