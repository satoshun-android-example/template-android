package io.github.satoshun.example

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import io.github.satoshun.example.feature.home.HomeScreen
import io.github.satoshun.example.feature.home.addHome
import io.github.satoshun.example.feature.next.NextScreen
import io.github.satoshun.example.feature.next.NextUser
import io.github.satoshun.example.feature.next.addNext
import io.github.satoshun.example.theme.AppTheme

@Composable
fun AppContent() {
  val navController = rememberNavController()

  Surface(modifier = Modifier.fillMaxSize()) {
    NavHost(
      navController = navController,
      startDestination = HomeScreen.createRoute(10),
      enterTransition = { EnterTransition.None },
      exitTransition = { ExitTransition.None },
    ) {
      addHome {
        navController.navigate(
          NextScreen.createRoute(
            count = 100,
            user = NextUser(
              id = 10,
              name = "satoshun",
            )
          )
        )
      }
      addNext()
    }
  }
}

@Preview
@Composable
fun PreviewAppContent() {
  AppTheme {
    Surface {
      AppContent()
    }
  }
}
