package io.github.satoshun.pino.feature.account;

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
public final class AccountPresenter_Factory_Impl implements AccountPresenter.Factory {
  private final AccountPresenter_Factory delegateFactory;

  AccountPresenter_Factory_Impl(AccountPresenter_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public AccountPresenter create(AccountScreen screen, Navigator navigator) {
    return delegateFactory.get(navigator, screen);
  }

  public static Provider<AccountPresenter.Factory> create(
      AccountPresenter_Factory delegateFactory) {
    return InstanceFactory.create(new AccountPresenter_Factory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<AccountPresenter.Factory> createFactoryProvider(
      AccountPresenter_Factory delegateFactory) {
    return InstanceFactory.create(new AccountPresenter_Factory_Impl(delegateFactory));
  }
}
