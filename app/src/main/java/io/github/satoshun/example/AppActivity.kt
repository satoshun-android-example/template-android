package io.github.satoshun.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.slack.circuit.backstack.rememberSaveableBackStack
import com.slack.circuit.foundation.Circuit
import com.slack.circuit.foundation.CircuitCompositionLocals
import com.slack.circuit.foundation.NavigableCircuitContent
import com.slack.circuit.foundation.rememberCircuitNavigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.ui.Ui
import dagger.hilt.android.AndroidEntryPoint
import io.github.satoshun.example.feature.home.HomeScreen
import io.github.satoshun.example.share.di.DaggerSet
import io.github.satoshun.example.theme.AppTheme
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
          val backStack = rememberSaveableBackStack(HomeScreen)
          val navigator = rememberCircuitNavigator(backStack)
          Surface(Modifier.fillMaxSize()) {
            NavigableCircuitContent(
              navigator = navigator,
              backStack = backStack,
            )
          }
        }
      }
    }
  }
}
