package io.github.satoshun.pino.feature.detail.imageinfo;

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
public final class DetailImageInfoFactory_Factory implements Factory<DetailImageInfoFactory> {
  @Override
  public DetailImageInfoFactory get() {
    return newInstance();
  }

  public static DetailImageInfoFactory_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static DetailImageInfoFactory newInstance() {
    return new DetailImageInfoFactory();
  }

  private static final class InstanceHolder {
    private static final DetailImageInfoFactory_Factory INSTANCE = new DetailImageInfoFactory_Factory();
  }
}
