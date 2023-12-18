package io.github.satoshun.example.share

import android.os.Bundle
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

abstract class Screen<Arguments>(
  route: String,
  val navArguments: List<NamedNavArgument> = emptyList(),
  val enterTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition?)? = null,
  val exitTransition: (AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition?)? = null,
) {
  val name: String = route.appendArguments(navArguments)

  abstract fun getArguments(bundle: Bundle?): Arguments
}

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
  val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
    .takeIf { it.isNotEmpty() }
    ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
    .orEmpty()
  val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
    .takeIf { it.isNotEmpty() }
    ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
    .orEmpty()
  return "$this$mandatoryArguments$optionalArguments"
}

fun <T> NavGraphBuilder.addScreen(
  screen: Screen<T>,
  content: @Composable AnimatedContentScope.(T) -> Unit,
) {
  composable(
    route = screen.name,
    arguments = screen.navArguments,
    enterTransition= screen.enterTransition,
    exitTransition = screen.exitTransition,
  ) {
    content(screen.getArguments(it.arguments))
  }
}
