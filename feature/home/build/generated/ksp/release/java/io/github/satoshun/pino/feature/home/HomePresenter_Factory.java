package io.github.satoshun.pino.feature.home;

import com.slack.circuit.runtime.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.github.satoshun.pino.share.data.HomeRepository;
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
public final class HomePresenter_Factory {
  private final Provider<HomeNavigator> homeNavigatorProvider;

  private final Provider<HomeRepository> homeRepositoryProvider;

  public HomePresenter_Factory(Provider<HomeNavigator> homeNavigatorProvider,
      Provider<HomeRepository> homeRepositoryProvider) {
    this.homeNavigatorProvider = homeNavigatorProvider;
    this.homeRepositoryProvider = homeRepositoryProvider;
  }

  public HomePresenter get(Navigator navigator) {
    return newInstance(navigator, homeNavigatorProvider.get(), homeRepositoryProvider.get());
  }

  public static HomePresenter_Factory create(Provider<HomeNavigator> homeNavigatorProvider,
      Provider<HomeRepository> homeRepositoryProvider) {
    return new HomePresenter_Factory(homeNavigatorProvider, homeRepositoryProvider);
  }

  public static HomePresenter newInstance(Navigator navigator, HomeNavigator homeNavigator,
      HomeRepository homeRepository) {
    return new HomePresenter(navigator, homeNavigator, homeRepository);
  }
}
