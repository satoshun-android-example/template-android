package io.github.satoshun.pino.feature.detail

import com.slack.circuit.runtime.screen.Screen
import io.github.satoshun.pino.share.data.Image
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailScreen(
  val image: Image,
) : Screen
