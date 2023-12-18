package io.github.satoshun.example.feature.next

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun Next(arguments: NextScreen.Arguments) {
  Scaffold { paddingValues ->
    Column(
      Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
      Text(text = "Next count ${arguments.count}")
      Text(text = "Next user ${arguments.user}")
    }
  }
}
