package io.github.satoshun.pino.feature.account.network;

import com.slack.circuit.runtime.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AccountNetworkPresenter_Factory {
  public AccountNetworkPresenter_Factory() {
  }

  public AccountNetworkPresenter get(Navigator navigator) {
    return newInstance(navigator);
  }

  public static AccountNetworkPresenter_Factory create() {
    return new AccountNetworkPresenter_Factory();
  }

  public static AccountNetworkPresenter newInstance(Navigator navigator) {
    return new AccountNetworkPresenter(navigator);
  }
}
