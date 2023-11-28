package io.github.satoshun.example.home

import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.navArgument

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

@Composable
private fun Home(
  arguments: HomeScreen.Arguments,
  onNavigate: () -> Unit
) {
  Scaffold(
    topBar = {
      TopAppBar(title = {
        Text(text = "Sample ${arguments.count}")
      })
    },
  ) { paddingValues ->
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = paddingValues
    ) {
      item {
        Button(onClick = onNavigate) {
          Text(text = "Next")
        }
      }
      items((1..100).map { it }) {
        Text(text = "Hello World $it")
      }
    }
  }
}
