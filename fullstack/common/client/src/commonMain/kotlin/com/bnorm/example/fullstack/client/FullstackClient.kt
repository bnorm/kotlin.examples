package com.bnorm.example.fullstack.client

import com.bnorm.example.fullstack.model.Todo
import com.bnorm.example.fullstack.model.TodoPrototype
import kotlin.jvm.JvmSuppressWildcards

expect annotation class GET(val value: String)
expect annotation class POST(val value: String)
expect annotation class Path(val value: String, val encoded: Boolean = false)
expect annotation class Query(val value: String, val encoded: Boolean = false)
expect annotation class Body()

@JvmSuppressWildcards
interface FullstackClient {
  @GET("todo/{id}")
  suspend fun getTodo(@Path("id") id: Int): Todo

  @GET("todo")
  suspend fun getTodo(
    @Query("page") page: Long = 0,
    @Query("count") count: Long = -1
  ): List<Todo>

  @POST("todo")
  suspend fun createTodo(@Body todo: TodoPrototype): Todo

  companion object Factory
}

expect fun FullstackClient.Factory.createClient(url: String): FullstackClient

