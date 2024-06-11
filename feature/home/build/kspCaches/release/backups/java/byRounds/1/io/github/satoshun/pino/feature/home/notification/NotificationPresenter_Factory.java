package io.github.satoshun.pino.feature.home.notification;

import com.slack.circuit.runtime.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.github.satoshun.pino.feature.home.notification.data.NotificationRepository;
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
public final class NotificationPresenter_Factory {
  private final Provider<NotificationRepository> repositoryProvider;

  public NotificationPresenter_Factory(Provider<NotificationRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  public NotificationPresenter get(Navigator navigator, NotificationScreen screen) {
    return newInstance(navigator, screen, repositoryProvider.get());
  }

  public static NotificationPresenter_Factory create(
      Provider<NotificationRepository> repositoryProvider) {
    return new NotificationPresenter_Factory(repositoryProvider);
  }

  public static NotificationPresenter newInstance(Navigator navigator, NotificationScreen screen,
      NotificationRepository repository) {
    return new NotificationPresenter(navigator, screen, repository);
  }
}
