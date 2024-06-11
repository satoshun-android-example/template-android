package io.github.satoshun.pino.feature.home

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import javax.inject.Inject

public class HomePresenterFactory @Inject constructor(
  private val factory: HomePresenter.Factory,
) : Presenter.Factory {
  override fun create(
    screen: Screen,
    navigator: Navigator,
    context: CircuitContext,
  ): Presenter<*>? = when (screen) {
    HomeScreen -> factory.create(navigator = navigator)
    else -> null
  }
}
