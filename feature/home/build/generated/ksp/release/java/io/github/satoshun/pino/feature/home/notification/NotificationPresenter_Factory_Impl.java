package io.github.satoshun.pino.feature.home.notification;

import com.slack.circuit.runtime.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class NotificationPresenter_Factory_Impl implements NotificationPresenter.Factory {
  private final NotificationPresenter_Factory delegateFactory;

  NotificationPresenter_Factory_Impl(NotificationPresenter_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public NotificationPresenter create(Navigator navigator, NotificationScreen screen) {
    return delegateFactory.get(navigator, screen);
  }

  public static Provider<NotificationPresenter.Factory> create(
      NotificationPresenter_Factory delegateFactory) {
    return InstanceFactory.create(new NotificationPresenter_Factory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<NotificationPresenter.Factory> createFactoryProvider(
      NotificationPresenter_Factory delegateFactory) {
    return InstanceFactory.create(new NotificationPresenter_Factory_Impl(delegateFactory));
  }
}
