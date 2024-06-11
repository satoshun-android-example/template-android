package io.github.satoshun.pino.feature.detail.image;

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
public final class DetailImagePresenter_Factory {
  public DetailImagePresenter_Factory() {
  }

  public DetailImagePresenter get(Navigator navigator, DetailImageScreen screen) {
    return newInstance(navigator, screen);
  }

  public static DetailImagePresenter_Factory create() {
    return new DetailImagePresenter_Factory();
  }

  public static DetailImagePresenter newInstance(Navigator navigator, DetailImageScreen screen) {
    return new DetailImagePresenter(navigator, screen);
  }
}
