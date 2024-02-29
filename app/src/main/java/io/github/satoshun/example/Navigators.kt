package io.github.satoshun.example

import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.ui.Ui
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.Multibinds
import io.github.satoshun.example.feature.home.HomeNavigator
import io.github.satoshun.example.feature.next.NextScreen
import io.github.satoshun.example.share.data.Image
import io.github.satoshun.example.share.di.DaggerSet
import javax.inject.Inject

class HomeNavigatorImpl @Inject constructor() : HomeNavigator {
  override fun goToNext(
    navigator: Navigator,
    image: Image,
  ) {
    navigator.goTo(NextScreen(image))
  }
}

@Module
@InstallIn(SingletonComponent::class)
interface NavigatorsModule {
  @Binds fun bindHomeNavigator(impl: HomeNavigatorImpl): HomeNavigator
  @Multibinds fun presenterFactories(): DaggerSet<Presenter.Factory>
  @Multibinds fun uiFactories(): DaggerSet<Ui.Factory>
}
