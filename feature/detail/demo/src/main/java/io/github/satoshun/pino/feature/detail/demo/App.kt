package io.github.satoshun.pino.feature.detail.demo

import android.app.Application
import com.slack.circuit.runtime.screen.Screen
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent
import io.github.satoshun.pino.feature.detail.DetailScreen
import io.github.satoshun.pino.share.data.Image

@HiltAndroidApp
class App : Application()

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
  @Provides
  fun startScreen(): Screen =
    DetailScreen(
      image = Image(url = "https://picsum.photos/id/1/200/300")
    )
}
