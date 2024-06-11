package io.github.satoshun.pino.feature.detail.image;

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
public final class DetailImagePresenter_Factory_Impl implements DetailImagePresenter.Factory {
  private final DetailImagePresenter_Factory delegateFactory;

  DetailImagePresenter_Factory_Impl(DetailImagePresenter_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public DetailImagePresenter create(DetailImageScreen screen, Navigator navigator) {
    return delegateFactory.get(navigator, screen);
  }

  public static Provider<DetailImagePresenter.Factory> create(
      DetailImagePresenter_Factory delegateFactory) {
    return InstanceFactory.create(new DetailImagePresenter_Factory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<DetailImagePresenter.Factory> createFactoryProvider(
      DetailImagePresenter_Factory delegateFactory) {
    return InstanceFactory.create(new DetailImagePresenter_Factory_Impl(delegateFactory));
  }
}
