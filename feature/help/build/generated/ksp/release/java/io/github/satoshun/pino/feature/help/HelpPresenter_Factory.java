package io.github.satoshun.pino.feature.help;

import com.slack.circuit.runtime.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.github.satoshun.pino.feature.help.data.HelpRepository;
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
public final class HelpPresenter_Factory {
  private final Provider<HelpRepository> repositoryProvider;

  public HelpPresenter_Factory(Provider<HelpRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  public HelpPresenter get(Navigator navigator, HelpScreen screen) {
    return newInstance(navigator, screen, repositoryProvider.get());
  }

  public static HelpPresenter_Factory create(Provider<HelpRepository> repositoryProvider) {
    return new HelpPresenter_Factory(repositoryProvider);
  }

  public static HelpPresenter newInstance(Navigator navigator, HelpScreen screen,
      HelpRepository repository) {
    return new HelpPresenter(navigator, screen, repository);
  }
}
