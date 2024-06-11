package io.github.satoshun.pino.feature.account.network

import com.slack.circuit.runtime.presenter.Presenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.codegen.OriginatingElement
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
@OriginatingElement(topLevelClass = AccountNetworkPresenter::class)
public abstract class AccountNetworkPresenterFactoryModule {
  @Binds
  @IntoSet
  public abstract
      fun bindAccountNetworkPresenterFactory(accountNetworkPresenterFactory: AccountNetworkPresenterFactory):
      Presenter.Factory
}
