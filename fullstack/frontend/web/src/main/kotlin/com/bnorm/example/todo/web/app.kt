package com.bnorm.example.todo.web

import com.bnorm.example.todo.client.TodoClient
import react.RBuilder
import react.dom.div

fun RBuilder.app(client: TodoClient) = div(classes = "App") {
  div(classes = "container-fluid") {
  }
}

