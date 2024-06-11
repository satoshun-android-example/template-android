package io.github.satoshun.pino.feature.account;

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
public final class AccountPresenterFactory_Factory implements Factory<AccountPresenterFactory> {
  private final Provider<AccountPresenter.Factory> factoryProvider;

  public AccountPresenterFactory_Factory(Provider<AccountPresenter.Factory> factoryProvider) {
    this.factoryProvider = factoryProvider;
  }

  @Override
  public AccountPresenterFactory get() {
    return newInstance(factoryProvider.get());
  }

  public static AccountPresenterFactory_Factory create(
      Provider<AccountPresenter.Factory> factoryProvider) {
    return new AccountPresenterFactory_Factory(factoryProvider);
  }

  public static AccountPresenterFactory newInstance(AccountPresenter.Factory factory) {
    return new AccountPresenterFactory(factory);
  }
}
