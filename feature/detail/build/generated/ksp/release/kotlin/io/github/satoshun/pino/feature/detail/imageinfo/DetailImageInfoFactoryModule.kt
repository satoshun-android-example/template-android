package io.github.satoshun.pino.feature.detail.imageinfo

import com.slack.circuit.runtime.ui.Ui
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
public abstract class DetailImageInfoFactoryModule {
  @Binds
  @IntoSet
  public abstract fun bindDetailImageInfoFactory(detailImageInfoFactory: DetailImageInfoFactory):
      Ui.Factory
}
