package io.github.satoshun.pino.feature.detail.image;

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
public final class DetailImageFactory_Factory implements Factory<DetailImageFactory> {
  @Override
  public DetailImageFactory get() {
    return newInstance();
  }

  public static DetailImageFactory_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DetailImageFactory newInstance() {
    return new DetailImageFactory();
  }

  private static final class InstanceHolder {
    private static final DetailImageFactory_Factory INSTANCE = new DetailImageFactory_Factory();
  }
}
