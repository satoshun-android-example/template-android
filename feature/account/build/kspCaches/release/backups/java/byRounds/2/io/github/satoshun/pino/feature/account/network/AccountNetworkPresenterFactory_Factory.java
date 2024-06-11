package io.github.satoshun.pino.feature.account.network;

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
public final class AccountNetworkPresenterFactory_Factory implements Factory<AccountNetworkPresenterFactory> {
  private final Provider<AccountNetworkPresenter.Factory> factoryProvider;

  public AccountNetworkPresenterFactory_Factory(
      Provider<AccountNetworkPresenter.Factory> factoryProvider) {
    this.factoryProvider = factoryProvider;
  }

  @Override
  public AccountNetworkPresenterFactory get() {
    return newInstance(factoryProvider.get());
  }

  public static AccountNetworkPresenterFactory_Factory create(
      Provider<AccountNetworkPresenter.Factory> factoryProvider) {
    return new AccountNetworkPresenterFactory_Factory(factoryProvider);
  }

  public static AccountNetworkPresenterFactory newInstance(
      AccountNetworkPresenter.Factory factory) {
    return new AccountNetworkPresenterFactory(factory);
  }
}
