package com.bnorm.example.todo.model

import kotlinx.serialization.Serializable

@Serializable
class TodoPrototype(
  val title: String,
  val description: String? = null
)

@Serializable
class Todo(
  val id: Long,
  val title: String,
  val description: String? = null
)
