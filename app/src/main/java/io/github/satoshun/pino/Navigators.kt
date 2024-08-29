package io.github.satoshun.pino

import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.ui.Ui
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.Multibinds
import io.github.satoshun.pino.share.di.DaggerSet

@Module
@InstallIn(SingletonComponent::class)
interface NavigatorsModule {
  @Multibinds fun presenterFactories(): DaggerSet<Presenter.Factory>
  @Multibinds fun uiFactories(): DaggerSet<Ui.Factory>
}
