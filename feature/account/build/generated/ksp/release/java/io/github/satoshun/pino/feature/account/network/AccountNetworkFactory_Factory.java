package io.github.satoshun.pino.feature.account.network;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class AccountNetworkFactory_Factory implements Factory<AccountNetworkFactory> {
  @Override
  public AccountNetworkFactory get() {
    return newInstance();
  }

  public static AccountNetworkFactory_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AccountNetworkFactory newInstance() {
    return new AccountNetworkFactory();
  }

  private static final class InstanceHolder {
    private static final AccountNetworkFactory_Factory INSTANCE = new AccountNetworkFactory_Factory();
  }
}
