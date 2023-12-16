package io.github.satoshun.example.feature.home

import android.os.Bundle
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import io.github.satoshun.example.share.Screen
import io.github.satoshun.example.share.addScreen

data object HomeScreen : Screen<HomeScreen.Arguments>(
  route = "home",
  navArguments = listOf(navArgument("count") {
    type = NavType.IntType
  })
) {
  data class Arguments(
    val count: Int,
  )

  override fun getArguments(bundle: Bundle?) =
    Arguments(count = bundle?.getInt(navArguments[0].name) ?: 0)

  fun createRoute(count: Int) =
    name.replace("{${navArguments[0].name}}", count.toString())
}

fun NavGraphBuilder.addHome(
  onNavigate: () -> Unit,
) {
  addScreen(HomeScreen) { arguments ->
    Home(arguments = arguments, onNavigate = onNavigate)
  }
}
