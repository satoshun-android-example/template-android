package io.github.satoshun.pino.feature.home;

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
public final class HomePresenterFactory_Factory implements Factory<HomePresenterFactory> {
  private final Provider<HomePresenter.Factory> factoryProvider;

  public HomePresenterFactory_Factory(Provider<HomePresenter.Factory> factoryProvider) {
    this.factoryProvider = factoryProvider;
  }

  @Override
  public HomePresenterFactory get() {
    return newInstance(factoryProvider.get());
  }

  public static HomePresenterFactory_Factory create(
      Provider<HomePresenter.Factory> factoryProvider) {
    return new HomePresenterFactory_Factory(factoryProvider);
  }

  public static HomePresenterFactory newInstance(HomePresenter.Factory factory) {
    return new HomePresenterFactory(factory);
  }
}
