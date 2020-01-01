package com.bnorm.example.todo.client

import com.bnorm.example.todo.model.Todo
import com.bnorm.example.todo.model.TodoPrototype
import kotlin.jvm.JvmSuppressWildcards

expect annotation class GET(val value: String)
expect annotation class POST(val value: String)
expect annotation class Path(val value: String, val encoded: Boolean = false)
expect annotation class Query(val value: String, val encoded: Boolean = false)
expect annotation class Body()

@JvmSuppressWildcards
interface TodoClient {
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

expect fun TodoClient.Factory.createClient(url: String): TodoClient

