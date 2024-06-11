package io.github.satoshun.pino.feature.account.network;

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
public final class AccountNetworkPresenter_Factory_Impl implements AccountNetworkPresenter.Factory {
  private final AccountNetworkPresenter_Factory delegateFactory;

  AccountNetworkPresenter_Factory_Impl(AccountNetworkPresenter_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public AccountNetworkPresenter create(Navigator navigator) {
    return delegateFactory.get(navigator);
  }

  public static Provider<AccountNetworkPresenter.Factory> create(
      AccountNetworkPresenter_Factory delegateFactory) {
    return InstanceFactory.create(new AccountNetworkPresenter_Factory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<AccountNetworkPresenter.Factory> createFactoryProvider(
      AccountNetworkPresenter_Factory delegateFactory) {
    return InstanceFactory.create(new AccountNetworkPresenter_Factory_Impl(delegateFactory));
  }
}
