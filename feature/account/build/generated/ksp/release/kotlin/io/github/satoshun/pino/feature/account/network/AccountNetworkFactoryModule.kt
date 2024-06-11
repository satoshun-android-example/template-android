package io.github.satoshun.pino.feature.account.network

import com.slack.circuit.runtime.ui.Ui
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
public abstract class AccountNetworkFactoryModule {
  @Binds
  @IntoSet
  public abstract fun bindAccountNetworkFactory(accountNetworkFactory: AccountNetworkFactory):
      Ui.Factory
}
