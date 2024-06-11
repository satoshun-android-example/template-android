package io.github.satoshun.pino.feature.home.notification

import com.slack.circuit.runtime.presenter.Presenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.codegen.OriginatingElement
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
@OriginatingElement(topLevelClass = NotificationPresenter::class)
public abstract class NotificationPresenterFactoryModule {
  @Binds
  @IntoSet
  public abstract
      fun bindNotificationPresenterFactory(notificationPresenterFactory: NotificationPresenterFactory):
      Presenter.Factory
}
