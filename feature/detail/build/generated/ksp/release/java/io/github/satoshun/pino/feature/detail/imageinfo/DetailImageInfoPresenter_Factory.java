package io.github.satoshun.pino.feature.detail.imageinfo;

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
public final class DetailImageInfoPresenter_Factory {
  public DetailImageInfoPresenter_Factory() {
  }

  public DetailImageInfoPresenter get(Navigator navigator, DetailImageInfoScreen screen) {
    return newInstance(navigator, screen);
  }

  public static DetailImageInfoPresenter_Factory create() {
    return new DetailImageInfoPresenter_Factory();
  }

  public static DetailImageInfoPresenter newInstance(Navigator navigator,
      DetailImageInfoScreen screen) {
    return new DetailImageInfoPresenter(navigator, screen);
  }
}
