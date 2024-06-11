package io.github.satoshun.pino.feature.help

import com.slack.circuit.runtime.presenter.Presenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.codegen.OriginatingElement
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
@OriginatingElement(topLevelClass = HelpPresenter::class)
public abstract class HelpPresenterFactoryModule {
  @Binds
  @IntoSet
  public abstract fun bindHelpPresenterFactory(helpPresenterFactory: HelpPresenterFactory):
      Presenter.Factory
}
