package io.github.satoshun.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.withCreationCallback
import io.github.satoshun.example.share.Share
import io.github.satoshun.example.theme.AppTheme

@AndroidEntryPoint
class AppActivity : ComponentActivity() {
  private val viewModel: AppViewModel by viewModels(
    extrasProducer = {
      defaultViewModelCreationExtras.withCreationCallback<AppViewModelFactory> { factory ->
        factory.create(10)
      }
    }
  )

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    println(Share)
    println(viewModel)

    enableEdgeToEdge()

    setContent {
      AppTheme {
        AppContent()
      }
    }
  }
}
