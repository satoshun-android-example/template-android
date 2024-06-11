package io.github.satoshun.pino.feature.home.notification;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class NotificationFactory_Factory implements Factory<NotificationFactory> {
  @Override
  public NotificationFactory get() {
    return newInstance();
  }

  public static NotificationFactory_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static NotificationFactory newInstance() {
    return new NotificationFactory();
  }

  private static final class InstanceHolder {
    private static final NotificationFactory_Factory INSTANCE = new NotificationFactory_Factory();
  }
}
