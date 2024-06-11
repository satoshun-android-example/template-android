package io.github.satoshun.pino.feature.account.basic

import com.slack.circuit.runtime.presenter.Presenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.codegen.OriginatingElement
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
@OriginatingElement(topLevelClass = AccountBasicPresenter::class)
public abstract class AccountBasicPresenterFactoryModule {
  @Binds
  @IntoSet
  public abstract
      fun bindAccountBasicPresenterFactory(accountBasicPresenterFactory: AccountBasicPresenterFactory):
      Presenter.Factory
}
