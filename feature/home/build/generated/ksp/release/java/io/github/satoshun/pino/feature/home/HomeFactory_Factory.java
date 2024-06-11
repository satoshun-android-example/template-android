package io.github.satoshun.pino.feature.home;

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
public final class HomeFactory_Factory implements Factory<HomeFactory> {
  @Override
  public HomeFactory get() {
    return newInstance();
  }

  public static HomeFactory_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HomeFactory newInstance() {
    return new HomeFactory();
  }

  private static final class InstanceHolder {
    private static final HomeFactory_Factory INSTANCE = new HomeFactory_Factory();
  }
}
