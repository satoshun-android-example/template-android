package io.github.satoshun.pino.feature.detail;

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
public final class DetailPresenter_Factory_Impl implements DetailPresenter.Factory {
  private final DetailPresenter_Factory delegateFactory;

  DetailPresenter_Factory_Impl(DetailPresenter_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public DetailPresenter create(DetailScreen screen, Navigator navigator) {
    return delegateFactory.get(navigator, screen);
  }

  public static Provider<DetailPresenter.Factory> create(DetailPresenter_Factory delegateFactory) {
    return InstanceFactory.create(new DetailPresenter_Factory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<DetailPresenter.Factory> createFactoryProvider(
      DetailPresenter_Factory delegateFactory) {
    return InstanceFactory.create(new DetailPresenter_Factory_Impl(delegateFactory));
  }
}
