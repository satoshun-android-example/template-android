package io.github.satoshun.pino.feature.account.basic;

import com.slack.circuit.runtime.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class AccountBasicPresenter_Factory_Impl implements AccountBasicPresenter.Factory {
  private final AccountBasicPresenter_Factory delegateFactory;

  AccountBasicPresenter_Factory_Impl(AccountBasicPresenter_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public AccountBasicPresenter create(AccountBasicScreen screen, Navigator navigator) {
    return delegateFactory.get(navigator, screen);
  }

  public static Provider<AccountBasicPresenter.Factory> create(
      AccountBasicPresenter_Factory delegateFactory) {
    return InstanceFactory.create(new AccountBasicPresenter_Factory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<AccountBasicPresenter.Factory> createFactoryProvider(
      AccountBasicPresenter_Factory delegateFactory) {
    return InstanceFactory.create(new AccountBasicPresenter_Factory_Impl(delegateFactory));
  }
}
