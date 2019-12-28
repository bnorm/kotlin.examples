package com.bnorm.example.fullstack.web

import com.bnorm.example.fullstack.client.FullstackClient
import react.RBuilder
import react.dom.div

fun RBuilder.app(client: FullstackClient) = div(classes = "App") {
  div(classes = "container-fluid") {
  }
}

