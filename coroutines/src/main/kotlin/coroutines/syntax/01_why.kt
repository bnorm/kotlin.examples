package coroutines.syntax

import java.util.concurrent.CompletionStage


class Token
class Item
class Post

typealias Callback<T> = (Result<T>) -> Unit


//


//


//


//


//


//


//


//


//


//


fun requestToken(): Token {
  // makes request for token
  // blocks the thread waiting for the result
  // returns result when received
  TODO()
}


fun createPost(token: Token, item: Item): Post {
  // sends item to server
  // blocks the thread waiting for the result
  // returns resulting post
  TODO()
}


fun processPost(post: Post) {
  // does some local processing of result
  TODO()
}


fun postItemSequential(item: Item) {
  val token = requestToken()
  val post = createPost(token, item)
  processPost(post)
}


//


//


//


//


//


//


//


//


//


//


fun requestTokenAsync(callback: Callback<Token>) {
  // makes request for token
  // invokes callback when done
  // returns immediately
}


fun createPostAsync(token: Token, item: Item, callback: Callback<Post>) {
  // sends item to server
  // invokes callback when done
  // returns immediately
}


fun postItemCallback(item: Item) {
  requestTokenAsync({ token ->
    createPostAsync(token.getOrThrow(), item, { post ->
      processPost(post.getOrThrow())
    })
  })
  // ^ callback hell
  // also, what about error handling?
}


//


//


//


//


//


//


//


//


//


//


fun requestTokenAsync(): CompletionStage<Token> {
  // makes request for token
  // completes future when done
  // returns future immediately
  TODO()
}


fun createPostAsync(token: Token, item: Item): CompletionStage<Post> {
  // sends item to server
  // completes future when done
  // returns future immediately
  TODO()
}


fun postItemFuture(item: Item) {
  val token = requestTokenAsync()
  val post = token.thenCompose { createPostAsync(it, item) }
  post.thenApply { processPost(it) }
  // better, but requires operators for everything
}


//


//


//


//


//


//


//


//


//


//


suspend fun requestTokenSuspend(): Token {
  // makes request for token
  // SUSPENDS the COROUTINE waiting for the result
  // returns result when received
  TODO()
}


suspend fun createPostSuspend(token: Token, item: Item): Post {
  // sends item to server
  // SUSPENDS the COROUTINE waiting for the result
  // returns resulting post
  TODO()
}


suspend fun postItemCoroutines(item: Item) {
  val token = requestTokenSuspend()
  val post = createPostSuspend(token, item)
  processPost(post)
}

