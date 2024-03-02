package io.github.satoshun.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import com.slack.circuit.backstack.rememberSaveableBackStack
import com.slack.circuit.foundation.Circuit
import com.slack.circuit.foundation.CircuitCompositionLocals
import com.slack.circuit.foundation.NavigableCircuitContent
import com.slack.circuit.foundation.rememberCircuitNavigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuitx.gesturenavigation.GestureNavigationDecoration
import dagger.hilt.android.AndroidEntryPoint
import io.github.satoshun.example.feature.home.HomeScreen
import io.github.satoshun.example.share.di.DaggerSet
import io.github.satoshun.example.theme.AppTheme
import kotlinx.collections.immutable.persistentListOf
import javax.inject.Inject

@AndroidEntryPoint
class AppActivity : ComponentActivity() {
  @Inject lateinit var presenterFactories: DaggerSet<Presenter.Factory>
  @Inject lateinit var uiFactories: DaggerSet<Ui.Factory>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()

    val circuit = Circuit.Builder()
      .addPresenterFactories(presenterFactories)
      .addUiFactories(uiFactories)
      .build()

    setContent {
      AppTheme {
        CircuitCompositionLocals(circuit) {
          val stack = remember {
            persistentListOf(HomeScreen)
          }
          val backStack = rememberSaveableBackStack(stack)
          val navigator = rememberCircuitNavigator(backStack)

          NavigableCircuitContent(
            navigator = navigator,
            backStack = backStack,
            decoration = GestureNavigationDecoration(
              fallback = circuit.defaultNavDecoration,
              // Pop the back stack once the user has gone 'back'
              onBackInvoked = navigator::pop,
            ),
          )
        }
      }
    }
  }
}
