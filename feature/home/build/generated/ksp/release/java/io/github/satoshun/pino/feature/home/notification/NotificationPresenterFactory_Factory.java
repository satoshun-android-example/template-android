package io.github.satoshun.pino.feature.home.notification;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
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
public final class NotificationPresenterFactory_Factory implements Factory<NotificationPresenterFactory> {
  private final Provider<NotificationPresenter.Factory> factoryProvider;

  public NotificationPresenterFactory_Factory(
      Provider<NotificationPresenter.Factory> factoryProvider) {
    this.factoryProvider = factoryProvider;
  }

  @Override
  public NotificationPresenterFactory get() {
    return newInstance(factoryProvider.get());
  }

  public static NotificationPresenterFactory_Factory create(
      Provider<NotificationPresenter.Factory> factoryProvider) {
    return new NotificationPresenterFactory_Factory(factoryProvider);
  }

  public static NotificationPresenterFactory newInstance(NotificationPresenter.Factory factory) {
    return new NotificationPresenterFactory(factory);
  }
}
