package io.github.satoshun.pino.feature.home.notification.data;

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
public final class NotificationRepository_Factory implements Factory<NotificationRepository> {
  @Override
  public NotificationRepository get() {
    return newInstance();
  }

  public static NotificationRepository_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static NotificationRepository newInstance() {
    return new NotificationRepository();
  }

  private static final class InstanceHolder {
    private static final NotificationRepository_Factory INSTANCE = new NotificationRepository_Factory();
  }
}
