package io.github.satoshun.pino.feature.detail.imageinfo

import com.slack.circuit.runtime.presenter.Presenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.codegen.OriginatingElement
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
@OriginatingElement(topLevelClass = DetailImageInfoPresenter::class)
public abstract class DetailImageInfoPresenterFactoryModule {
  @Binds
  @IntoSet
  public abstract
      fun bindDetailImageInfoPresenterFactory(detailImageInfoPresenterFactory: DetailImageInfoPresenterFactory):
      Presenter.Factory
}
