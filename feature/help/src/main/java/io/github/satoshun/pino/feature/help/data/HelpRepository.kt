package io.github.satoshun.pino.feature.help.data

import kotlinx.coroutines.delay
import javax.inject.Inject

internal class HelpRepository @Inject constructor() {
  suspend fun getPopularHelp(): List<HelpItem> {
    delay(300)
    return emptyList()
  }
}

data class HelpItem(
  val id: Long,
  val title: String,
)
