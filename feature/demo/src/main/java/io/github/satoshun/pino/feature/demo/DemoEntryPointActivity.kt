package io.github.satoshun.pino.feature.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.slack.circuit.backstack.rememberSaveableBackStack
import com.slack.circuit.foundation.Circuit
import com.slack.circuit.foundation.CircuitCompositionLocals
import com.slack.circuit.foundation.NavigableCircuitContent
import com.slack.circuit.foundation.rememberCircuitNavigator
import com.slack.circuit.overlay.ContentWithOverlays
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuitx.android.rememberAndroidScreenAwareNavigator
import com.slack.circuitx.gesturenavigation.GestureNavigationDecorationFactory
import dagger.hilt.android.AndroidEntryPoint
import io.github.satoshun.pino.designsystem.theme.PinoTheme
import io.github.satoshun.pino.share.di.DaggerSet
import kotlinx.collections.immutable.persistentListOf
import javax.inject.Inject

@AndroidEntryPoint
class DemoEntryPointActivity : ComponentActivity() {
  @Inject lateinit var startScreen: Screen
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
      PinoTheme {
        CircuitCompositionLocals(circuit) {
          ContentWithOverlays {
            val stack = remember {
              persistentListOf(startScreen)
            }
            val backStack = rememberSaveableBackStack(stack)
            val navigator = rememberCircuitNavigator(backStack)
            val intentAwareNavigator =
              rememberAndroidScreenAwareNavigator(navigator, this@DemoEntryPointActivity)

            Surface(Modifier.fillMaxSize()) {
              NavigableCircuitContent(
                navigator = intentAwareNavigator,
                backStack = backStack,
                decoratorFactory = GestureNavigationDecorationFactory(
                  // Pop the back stack once the user has gone 'back'
                  onBackInvoked = navigator::pop,
                ),
              )
            }
          }
        }
      }
    }
  }
}
