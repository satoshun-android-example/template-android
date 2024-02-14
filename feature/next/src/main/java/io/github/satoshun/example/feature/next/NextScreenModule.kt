package io.github.satoshun.example.feature.next

import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.ui.Ui
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@InstallIn(SingletonComponent::class)
@Module
internal interface NextScreenModule {
  @Binds
  @IntoSet
  fun bindNextPresenterFactory(impl: NextPresenterFactory): Presenter.Factory

  @Binds
  @IntoSet
  fun bindNextUiFactory(impl: NextUiFactory): Ui.Factory
}
