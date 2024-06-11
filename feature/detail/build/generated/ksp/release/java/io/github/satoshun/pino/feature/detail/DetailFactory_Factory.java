package io.github.satoshun.pino.feature.detail;

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
public final class DetailFactory_Factory implements Factory<DetailFactory> {
  @Override
  public DetailFactory get() {
    return newInstance();
  }

  public static DetailFactory_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DetailFactory newInstance() {
    return new DetailFactory();
  }

  private static final class InstanceHolder {
    private static final DetailFactory_Factory INSTANCE = new DetailFactory_Factory();
  }
}
