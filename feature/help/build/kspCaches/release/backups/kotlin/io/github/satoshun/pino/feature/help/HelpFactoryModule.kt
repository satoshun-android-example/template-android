package io.github.satoshun.pino.feature.help

import com.slack.circuit.runtime.ui.Ui
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
public abstract class HelpFactoryModule {
  @Binds
  @IntoSet
  public abstract fun bindHelpFactory(helpFactory: HelpFactory): Ui.Factory
}
