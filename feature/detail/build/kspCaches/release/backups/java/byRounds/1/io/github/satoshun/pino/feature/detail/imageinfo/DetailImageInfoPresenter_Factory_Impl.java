package io.github.satoshun.pino.feature.detail.imageinfo;

import com.slack.circuit.runtime.Navigator;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class DetailImageInfoPresenter_Factory_Impl implements DetailImageInfoPresenter.Factory {
  private final DetailImageInfoPresenter_Factory delegateFactory;

  DetailImageInfoPresenter_Factory_Impl(DetailImageInfoPresenter_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public DetailImageInfoPresenter create(DetailImageInfoScreen screen, Navigator navigator) {
    return delegateFactory.get(navigator, screen);
  }

  public static Provider<DetailImageInfoPresenter.Factory> create(
      DetailImageInfoPresenter_Factory delegateFactory) {
    return InstanceFactory.create(new DetailImageInfoPresenter_Factory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<DetailImageInfoPresenter.Factory> createFactoryProvider(
      DetailImageInfoPresenter_Factory delegateFactory) {
    return InstanceFactory.create(new DetailImageInfoPresenter_Factory_Impl(delegateFactory));
  }
}
