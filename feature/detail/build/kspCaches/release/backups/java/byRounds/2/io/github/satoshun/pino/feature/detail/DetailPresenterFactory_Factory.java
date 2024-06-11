package io.github.satoshun.pino.feature.detail;

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
public final class DetailPresenterFactory_Factory implements Factory<DetailPresenterFactory> {
  private final Provider<DetailPresenter.Factory> factoryProvider;

  public DetailPresenterFactory_Factory(Provider<DetailPresenter.Factory> factoryProvider) {
    this.factoryProvider = factoryProvider;
  }

  @Override
  public DetailPresenterFactory get() {
    return newInstance(factoryProvider.get());
  }

  public static DetailPresenterFactory_Factory create(
      Provider<DetailPresenter.Factory> factoryProvider) {
    return new DetailPresenterFactory_Factory(factoryProvider);
  }

  public static DetailPresenterFactory newInstance(DetailPresenter.Factory factory) {
    return new DetailPresenterFactory(factory);
  }
}
