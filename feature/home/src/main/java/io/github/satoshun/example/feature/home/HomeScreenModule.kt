package io.github.satoshun.example.feature.home

import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.ui.Ui
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@InstallIn(SingletonComponent::class)
@Module
internal interface HomeScreenModule {
  @Binds
  @IntoSet
  fun bindHomePresenterFactory(impl: HomePresenterFactory): Presenter.Factory

  @Binds
  @IntoSet
  fun bindHomeUiFactory(impl: HomeUiFactory): Ui.Factory
}
