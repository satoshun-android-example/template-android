package io.github.satoshun.pino.share.data;

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
public final class HomeRepository_Factory implements Factory<HomeRepository> {
  @Override
  public HomeRepository get() {
    return newInstance();
  }

  public static HomeRepository_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HomeRepository newInstance() {
    return new HomeRepository();
  }

  private static final class InstanceHolder {
    private static final HomeRepository_Factory INSTANCE = new HomeRepository_Factory();
  }
}
