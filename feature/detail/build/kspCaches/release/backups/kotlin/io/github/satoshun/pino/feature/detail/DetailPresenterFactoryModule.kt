package io.github.satoshun.pino.feature.detail

import com.slack.circuit.runtime.presenter.Presenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.codegen.OriginatingElement
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
@OriginatingElement(topLevelClass = DetailPresenter::class)
public abstract class DetailPresenterFactoryModule {
  @Binds
  @IntoSet
  public abstract fun bindDetailPresenterFactory(detailPresenterFactory: DetailPresenterFactory):
      Presenter.Factory
}
