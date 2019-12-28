package com.bnorm.example.fullstack.client

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.HttpUrl
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

actual typealias GET = retrofit2.http.GET
actual typealias POST = retrofit2.http.POST
@Suppress("ACTUAL_ANNOTATION_CONFLICTING_DEFAULT_ARGUMENT_VALUE")
actual typealias Path = retrofit2.http.Path
@Suppress("ACTUAL_ANNOTATION_CONFLICTING_DEFAULT_ARGUMENT_VALUE")
actual typealias Query = retrofit2.http.Query
actual typealias Body = retrofit2.http.Body

actual fun FullstackClient.Factory.createClient(url: String): FullstackClient =
  createClient(HttpUrl.get(url))

fun FullstackClient.Factory.createClient(
  url: HttpUrl,
  client: OkHttpClient = OkHttpClient()
): FullstackClient {
  return Retrofit.Builder()
    .baseUrl(
      url.newBuilder()
        .addPathSegment("api")
        .addPathSegment("v1")
        .addPathSegment("") // Add trailing '/' for relative paths
        .build()
    )
    .client(client)
    .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
    .validateEagerly(true)
    .build()
    .create(FullstackClient::class.java)
}
