package io.github.satoshun.example.feature.next

import android.os.Bundle
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument
import io.github.satoshun.example.share.Screen
import io.github.satoshun.example.share.addScreen

data object NextScreen : Screen<NextScreen.Arguments>(
  route = "next",
  navArguments = listOf(
    navArgument("count") {
      type = NavType.IntType
    },
    navArgument("user") {
      type = NextUserType
    },
  ),
  enterTransition = {
    fadeIn(
      animationSpec = tween(
        durationMillis = 500,
        easing = LinearEasing
      )
    ) + slideIntoContainer(
      animationSpec = tween(500, easing = EaseIn),
      towards = AnimatedContentTransitionScope.SlideDirection.Start
    )
  },
  exitTransition = {
    fadeOut(
      animationSpec = tween(
        durationMillis = 500,
        easing = LinearEasing
      )
    ) + slideOutOfContainer(
      animationSpec = tween(500, easing = EaseOut),
      towards = AnimatedContentTransitionScope.SlideDirection.End
    )
  },
) {
  data class Arguments(
    val count: Int,
    val user: NextUser?,
  )

  override fun getArguments(bundle: Bundle?): Arguments =
    Arguments(
      count = bundle?.getInt(navArguments[0].name) ?: 0,
      user = bundle?.getParcelable(navArguments[1].name),
    )

  fun createRoute(
    count: Int,
    user: NextUser,
  ) =
    name.replace("{${NextScreen.navArguments[0].name}}", count.toString())
      .replace("{${NextScreen.navArguments[1].name}}", NextUserType.encodeToString(user))
}

fun NavGraphBuilder.addNext() {
  addScreen(NextScreen) { _, arguments ->
    Next(arguments)
  }
}
