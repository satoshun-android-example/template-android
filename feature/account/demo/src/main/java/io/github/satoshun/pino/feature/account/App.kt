package io.github.satoshun.pino.feature.account

import android.app.Application
import com.slack.circuit.runtime.screen.Screen
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent

@HiltAndroidApp
class App : Application()

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
  @Provides
  fun startScreen(): Screen =
    AccountScreen()
}