package io.github.satoshun.pino.feature.help.data;

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
public final class HelpRepository_Factory implements Factory<HelpRepository> {
  @Override
  public HelpRepository get() {
    return newInstance();
  }

  public static HelpRepository_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HelpRepository newInstance() {
    return new HelpRepository();
  }

  private static final class InstanceHolder {
    private static final HelpRepository_Factory INSTANCE = new HelpRepository_Factory();
  }
}
