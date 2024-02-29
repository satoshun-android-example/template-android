package io.github.satoshun.example.share.data

import android.os.Parcelable
import kotlinx.coroutines.delay
import kotlinx.parcelize.Parcelize
import javax.inject.Inject

@Parcelize
data class Image(
  val url: String,
) : Parcelable

class HomeRepository @Inject constructor() {
  suspend fun getImages(): List<Image> {
    delay(3000)
    return (1..100).map {
      Image("https://picsum.photos/id/$it/200/300")
    }
  }
}