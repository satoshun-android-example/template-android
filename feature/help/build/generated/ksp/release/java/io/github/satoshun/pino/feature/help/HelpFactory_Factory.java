package io.github.satoshun.pino.feature.help;

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
public final class HelpFactory_Factory implements Factory<HelpFactory> {
  @Override
  public HelpFactory get() {
    return newInstance();
  }

  public static HelpFactory_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HelpFactory newInstance() {
    return new HelpFactory();
  }

  private static final class InstanceHolder {
    private static final HelpFactory_Factory INSTANCE = new HelpFactory_Factory();
  }
}
