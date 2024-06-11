package io.github.satoshun.pino.feature.account.basic;

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
public final class AccountBasicFactory_Factory implements Factory<AccountBasicFactory> {
  @Override
  public AccountBasicFactory get() {
    return newInstance();
  }

  public static AccountBasicFactory_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AccountBasicFactory newInstance() {
    return new AccountBasicFactory();
  }

  private static final class InstanceHolder {
    private static final AccountBasicFactory_Factory INSTANCE = new AccountBasicFactory_Factory();
  }
}
