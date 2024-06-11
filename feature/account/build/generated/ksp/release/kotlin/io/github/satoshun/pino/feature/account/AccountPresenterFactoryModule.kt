package io.github.satoshun.pino.feature.account

import com.slack.circuit.runtime.presenter.Presenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.codegen.OriginatingElement
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
@OriginatingElement(topLevelClass = AccountPresenter::class)
public abstract class AccountPresenterFactoryModule {
  @Binds
  @IntoSet
  public abstract fun bindAccountPresenterFactory(accountPresenterFactory: AccountPresenterFactory):
      Presenter.Factory
}
