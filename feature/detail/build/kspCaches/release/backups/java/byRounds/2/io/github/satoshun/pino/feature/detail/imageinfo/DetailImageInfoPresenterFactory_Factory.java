package io.github.satoshun.pino.feature.detail.imageinfo;

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
public final class DetailImageInfoPresenterFactory_Factory implements Factory<DetailImageInfoPresenterFactory> {
  private final Provider<DetailImageInfoPresenter.Factory> factoryProvider;

  public DetailImageInfoPresenterFactory_Factory(
      Provider<DetailImageInfoPresenter.Factory> factoryProvider) {
    this.factoryProvider = factoryProvider;
  }

  @Override
  public DetailImageInfoPresenterFactory get() {
    return newInstance(factoryProvider.get());
  }

  public static DetailImageInfoPresenterFactory_Factory create(
      Provider<DetailImageInfoPresenter.Factory> factoryProvider) {
    return new DetailImageInfoPresenterFactory_Factory(factoryProvider);
  }

  public static DetailImageInfoPresenterFactory newInstance(
      DetailImageInfoPresenter.Factory factory) {
    return new DetailImageInfoPresenterFactory(factory);
  }
}
