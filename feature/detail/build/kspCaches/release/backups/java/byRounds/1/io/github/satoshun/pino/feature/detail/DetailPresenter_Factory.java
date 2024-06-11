package io.github.satoshun.pino.feature.detail;

import com.slack.circuit.runtime.Navigator;
import dagger.internal.DaggerGenerated;
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
public final class DetailPresenter_Factory {
  public DetailPresenter_Factory() {
  }

  public DetailPresenter get(Navigator navigator, DetailScreen screen) {
    return newInstance(navigator, screen);
  }

  public static DetailPresenter_Factory create() {
    return new DetailPresenter_Factory();
  }

  public static DetailPresenter newInstance(Navigator navigator, DetailScreen screen) {
    return new DetailPresenter(navigator, screen);
  }
}
