package io.github.satoshun.example.feature.home

import android.os.Bundle
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import io.github.satoshun.example.share.Screen
import io.github.satoshun.example.share.addScreen

data object HomeScreen : Screen<HomeScreen.Arguments>(
  route = "home",
  navArguments = listOf(
    navArgument("count") {
      type = NavType.IntType
    },
  ),
  enterTransition = {
    fadeIn(
      animationSpec = tween(
        durationMillis = 500,
        easing = LinearEasing
      )
    )
  },
  exitTransition = {
    fadeOut(
      animationSpec = tween(
        durationMillis = 500,
        easing = LinearEasing
      )
    )
  },
) {
  data class Arguments(
    val count: Int,
  )

  override fun getArguments(bundle: Bundle?) =
    Arguments(count = bundle?.getInt(navArguments[0].name) ?: 0)

  fun createRoute(
    count: Int,
  ) =
    name.replace("{${navArguments[0].name}}", count.toString())
}

fun NavGraphBuilder.addHome(
  onNavigate: () -> Unit,
) {
  addScreen(HomeScreen) { _, arguments ->
    Home(arguments = arguments, onNavigate = onNavigate)
  }
}
