package com.bnorm.example.todo.client

import com.bnorm.example.todo.model.Todo
import com.bnorm.example.todo.model.TodoPrototype
import kotlinx.serialization.json.Json
import kotlinx.serialization.list

actual annotation class GET actual constructor(actual val value: String)
actual annotation class POST actual constructor(actual val value: String)
actual annotation class Path actual constructor(actual val value: String, actual val encoded: Boolean)
actual annotation class Query actual constructor(actual val value: String, actual val encoded: Boolean)
actual annotation class Body actual constructor()

actual fun TodoClient.Factory.createClient(url: String): TodoClient {
  return object : TodoClient {
    override suspend fun getTodo(id: Int): Todo {
      val response = request("GET", "$url/todo/$id")
      return Json.plain.parse(Todo.serializer(), response)
    }

    override suspend fun getTodo(page: Long, count: Long): List<Todo> {
      val params = mutableListOf<String>()
      if (count > 0) {
        params.add("page=$page")
        params.add("count=$count")
      }

      val response = request("GET", "$url/actions?${params.joinToString(separator = "&")}")
      return Json.plain.parse(Todo.serializer().list, response)
    }

    override suspend fun createTodo(todo: TodoPrototype): Todo {
      val response = request("POST", "$url/todo", Json.plain.stringify(TodoPrototype.serializer(), todo))
      return Json.plain.parse(Todo.serializer(), response)
    }
  }
}
