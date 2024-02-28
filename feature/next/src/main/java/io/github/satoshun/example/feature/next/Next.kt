package io.github.satoshun.example.feature.next

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.components.SingletonComponent

@CircuitInject(NextScreen::class, SingletonComponent::class)
@Composable
internal fun NextContent(
  state: NextState,
  modifier: Modifier = Modifier,
) {
  Scaffold(modifier) { paddingValues ->
    Column(
      Modifier
        .fillMaxSize()
        .padding(paddingValues)
    ) {
      Text(text = "Next count ${state.count}")
      Text(text = "Next user ${state.user}")
    }
  }
}
