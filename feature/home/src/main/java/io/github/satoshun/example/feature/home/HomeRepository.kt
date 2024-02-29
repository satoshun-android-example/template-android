package io.github.satoshun.example.feature.home

import kotlinx.coroutines.delay
import javax.inject.Inject

internal class HomeRepository @Inject constructor() {
  suspend fun getImages(): List<Image> {
    delay(3000)
    return (1..100).map {
      Image("https://picsum.photos/id/$it/200/300")
    }
  }
}

data class Image(
  val url: String,
)
