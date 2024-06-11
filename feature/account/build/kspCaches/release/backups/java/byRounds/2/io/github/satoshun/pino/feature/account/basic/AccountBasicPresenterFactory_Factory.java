package io.github.satoshun.pino.feature.account.basic;

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
public final class AccountBasicPresenterFactory_Factory implements Factory<AccountBasicPresenterFactory> {
  private final Provider<AccountBasicPresenter.Factory> factoryProvider;

  public AccountBasicPresenterFactory_Factory(
      Provider<AccountBasicPresenter.Factory> factoryProvider) {
    this.factoryProvider = factoryProvider;
  }

  @Override
  public AccountBasicPresenterFactory get() {
    return newInstance(factoryProvider.get());
  }

  public static AccountBasicPresenterFactory_Factory create(
      Provider<AccountBasicPresenter.Factory> factoryProvider) {
    return new AccountBasicPresenterFactory_Factory(factoryProvider);
  }

  public static AccountBasicPresenterFactory newInstance(AccountBasicPresenter.Factory factory) {
    return new AccountBasicPresenterFactory(factory);
  }
}
