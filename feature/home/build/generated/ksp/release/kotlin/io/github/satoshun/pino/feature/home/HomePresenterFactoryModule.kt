package io.github.satoshun.pino.feature.home

import com.slack.circuit.runtime.presenter.Presenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.codegen.OriginatingElement
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
@OriginatingElement(topLevelClass = HomePresenter::class)
public abstract class HomePresenterFactoryModule {
  @Binds
  @IntoSet
  public abstract fun bindHomePresenterFactory(homePresenterFactory: HomePresenterFactory):
      Presenter.Factory
}
