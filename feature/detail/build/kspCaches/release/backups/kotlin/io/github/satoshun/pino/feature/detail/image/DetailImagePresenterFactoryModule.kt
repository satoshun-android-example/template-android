package io.github.satoshun.pino.feature.detail.image

import com.slack.circuit.runtime.presenter.Presenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.codegen.OriginatingElement
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
@OriginatingElement(topLevelClass = DetailImagePresenter::class)
public abstract class DetailImagePresenterFactoryModule {
  @Binds
  @IntoSet
  public abstract
      fun bindDetailImagePresenterFactory(detailImagePresenterFactory: DetailImagePresenterFactory):
      Presenter.Factory
}
