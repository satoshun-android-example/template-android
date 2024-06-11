package io.github.satoshun.pino.feature.account;

import com.slack.circuit.runtime.Navigator;
import com.slack.circuit.runtime.presenter.Presenter;
import com.slack.circuit.runtime.ui.Ui;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.Set;
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
public final class AccountPresenter_Factory {
  private final Provider<AccountNavigator> accountNavigatorProvider;

  private final Provider<Set<Presenter.Factory>> presenterFactoriesProvider;

  private final Provider<Set<Ui.Factory>> uiFactoriesProvider;

  public AccountPresenter_Factory(Provider<AccountNavigator> accountNavigatorProvider,
      Provider<Set<Presenter.Factory>> presenterFactoriesProvider,
      Provider<Set<Ui.Factory>> uiFactoriesProvider) {
    this.accountNavigatorProvider = accountNavigatorProvider;
    this.presenterFactoriesProvider = presenterFactoriesProvider;
    this.uiFactoriesProvider = uiFactoriesProvider;
  }

  public AccountPresenter get(Navigator navigator, AccountScreen screen) {
    return newInstance(accountNavigatorProvider.get(), presenterFactoriesProvider.get(), uiFactoriesProvider.get(), navigator, screen);
  }

  public static AccountPresenter_Factory create(Provider<AccountNavigator> accountNavigatorProvider,
      Provider<Set<Presenter.Factory>> presenterFactoriesProvider,
      Provider<Set<Ui.Factory>> uiFactoriesProvider) {
    return new AccountPresenter_Factory(accountNavigatorProvider, presenterFactoriesProvider, uiFactoriesProvider);
  }

  public static AccountPresenter newInstance(AccountNavigator accountNavigator,
      Set<Presenter.Factory> presenterFactories, Set<Ui.Factory> uiFactories, Navigator navigator,
      AccountScreen screen) {
    return new AccountPresenter(accountNavigator, presenterFactories, uiFactories, navigator, screen);
  }
}
