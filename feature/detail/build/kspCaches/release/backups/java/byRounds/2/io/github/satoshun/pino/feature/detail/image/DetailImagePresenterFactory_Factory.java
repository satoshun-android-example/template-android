package io.github.satoshun.pino.feature.detail.image;

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
public final class DetailImagePresenterFactory_Factory implements Factory<DetailImagePresenterFactory> {
  private final Provider<DetailImagePresenter.Factory> factoryProvider;

  public DetailImagePresenterFactory_Factory(
      Provider<DetailImagePresenter.Factory> factoryProvider) {
    this.factoryProvider = factoryProvider;
  }

  @Override
  public DetailImagePresenterFactory get() {
    return newInstance(factoryProvider.get());
  }

  public static DetailImagePresenterFactory_Factory create(
      Provider<DetailImagePresenter.Factory> factoryProvider) {
    return new DetailImagePresenterFactory_Factory(factoryProvider);
  }

  public static DetailImagePresenterFactory newInstance(DetailImagePresenter.Factory factory) {
    return new DetailImagePresenterFactory(factory);
  }
}
