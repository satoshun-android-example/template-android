package io.github.satoshun.pino.feature.account.basic

import com.slack.circuit.runtime.ui.Ui
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
public abstract class AccountBasicFactoryModule {
  @Binds
  @IntoSet
  public abstract fun bindAccountBasicFactory(accountBasicFactory: AccountBasicFactory): Ui.Factory
}
