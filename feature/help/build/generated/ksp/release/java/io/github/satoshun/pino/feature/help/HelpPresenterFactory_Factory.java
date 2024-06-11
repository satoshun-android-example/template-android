package io.github.satoshun.pino.feature.help;

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
public final class HelpPresenterFactory_Factory implements Factory<HelpPresenterFactory> {
  private final Provider<HelpPresenter.Factory> factoryProvider;

  public HelpPresenterFactory_Factory(Provider<HelpPresenter.Factory> factoryProvider) {
    this.factoryProvider = factoryProvider;
  }

  @Override
  public HelpPresenterFactory get() {
    return newInstance(factoryProvider.get());
  }

  public static HelpPresenterFactory_Factory create(
      Provider<HelpPresenter.Factory> factoryProvider) {
    return new HelpPresenterFactory_Factory(factoryProvider);
  }

  public static HelpPresenterFactory newInstance(HelpPresenter.Factory factory) {
    return new HelpPresenterFactory(factory);
  }
}
