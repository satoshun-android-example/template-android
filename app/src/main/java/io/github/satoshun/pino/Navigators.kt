package io.github.satoshun.pino

import com.slack.circuit.overlay.OverlayHost
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuitx.overlays.showFullScreenOverlay
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.Multibinds
import io.github.satoshun.pino.feature.home.HomeNavigator
import io.github.satoshun.pino.feature.next.NextScreen
import io.github.satoshun.pino.share.data.Image
import io.github.satoshun.pino.share.di.DaggerSet
import javax.inject.Inject

class HomeNavigatorImpl @Inject constructor() : HomeNavigator {
  override suspend fun goToNext(
    host: OverlayHost,
    image: Image,
  ) {
    host.showFullScreenOverlay(NextScreen(image))
  }
}

@Module
@InstallIn(SingletonComponent::class)
interface NavigatorsModule {
  @Binds fun bindHomeNavigator(impl: HomeNavigatorImpl): HomeNavigator
  @Multibinds fun presenterFactories(): DaggerSet<Presenter.Factory>
  @Multibinds fun uiFactories(): DaggerSet<Ui.Factory>
}
