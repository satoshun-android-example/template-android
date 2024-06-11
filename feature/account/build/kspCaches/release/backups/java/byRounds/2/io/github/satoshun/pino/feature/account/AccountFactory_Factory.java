package io.github.satoshun.pino.feature.account;

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
public final class AccountFactory_Factory implements Factory<AccountFactory> {
  @Override
  public AccountFactory get() {
    return newInstance();
  }

  public static AccountFactory_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AccountFactory newInstance() {
    return new AccountFactory();
  }

  private static final class InstanceHolder {
    private static final AccountFactory_Factory INSTANCE = new AccountFactory_Factory();
  }
}
