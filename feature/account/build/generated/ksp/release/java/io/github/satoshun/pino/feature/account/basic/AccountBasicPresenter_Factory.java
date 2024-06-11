package io.github.satoshun.pino.feature.account.basic;

import com.slack.circuit.runtime.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.github.satoshun.pino.feature.account.AccountNavigator;
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
public final class AccountBasicPresenter_Factory {
  private final Provider<AccountNavigator> accountNavigatorProvider;

  public AccountBasicPresenter_Factory(Provider<AccountNavigator> accountNavigatorProvider) {
    this.accountNavigatorProvider = accountNavigatorProvider;
  }

  public AccountBasicPresenter get(Navigator navigator, AccountBasicScreen screen) {
    return newInstance(accountNavigatorProvider.get(), navigator, screen);
  }

  public static AccountBasicPresenter_Factory create(
      Provider<AccountNavigator> accountNavigatorProvider) {
    return new AccountBasicPresenter_Factory(accountNavigatorProvider);
  }

  public static AccountBasicPresenter newInstance(AccountNavigator accountNavigator,
      Navigator navigator, AccountBasicScreen screen) {
    return new AccountBasicPresenter(accountNavigator, navigator, screen);
  }
}
