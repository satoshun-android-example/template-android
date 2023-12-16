package io.github.satoshun.example.next

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
import io.github.satoshun.example.home.HomeScreen
import io.github.satoshun.example.home.Screen

data object NextScreen : Screen<NextScreen.Arguments>(
  route = "next",
  navArguments = listOf(
    navArgument("count") {
      type = NavType.IntType
    },
    navArgument("user") {
    },
  )
) {
  data class Arguments(
    val count: Int,
  )

  override fun getArguments(bundle: Bundle?): Arguments =
    Arguments(
      count = bundle?.getInt(navArguments[0].name) ?: 0,
    )

  fun createRoute(count: Int) =
    name.replace("{${HomeScreen.navArguments[0].name}}", count.toString())
}

fun NavGraphBuilder.addNext() {
  composable(
    route = NextScreen.name,
    arguments = NextScreen.navArguments,
    enterTransition = {
      slideIn(
        initialOffset = { IntOffset(0, it.height) },
        animationSpec = tween(2000)
      )
    },
    exitTransition = {
      slideOut(
        targetOffset = { IntOffset(0, it.height) },
        animationSpec = tween(3000)
      )
    },
  ) {
    val arguments = NextScreen.getArguments(it.arguments)
    Next(arguments)
  }
}

@Composable
private fun Next(arguments: NextScreen.Arguments) {
  Scaffold { paddingValues ->
    Column(
      Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
      Text(text = "Next ${arguments.count}")
    }
  }
}
