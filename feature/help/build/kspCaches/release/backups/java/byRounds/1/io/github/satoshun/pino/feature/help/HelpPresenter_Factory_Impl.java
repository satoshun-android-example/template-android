package io.github.satoshun.pino.feature.help;

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
public final class HelpPresenter_Factory_Impl implements HelpPresenter.Factory {
  private final HelpPresenter_Factory delegateFactory;

  HelpPresenter_Factory_Impl(HelpPresenter_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public HelpPresenter create(HelpScreen screen, Navigator navigator) {
    return delegateFactory.get(navigator, screen);
  }

  public static Provider<HelpPresenter.Factory> create(HelpPresenter_Factory delegateFactory) {
    return InstanceFactory.create(new HelpPresenter_Factory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<HelpPresenter.Factory> createFactoryProvider(
      HelpPresenter_Factory delegateFactory) {
    return InstanceFactory.create(new HelpPresenter_Factory_Impl(delegateFactory));
  }
}
