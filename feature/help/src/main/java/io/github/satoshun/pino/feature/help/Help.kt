package io.github.satoshun.pino.feature.help

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.components.SingletonComponent
import io.github.satoshun.pino.share.ui.SectionTitle

@CircuitInject(HelpScreen::class, SingletonComponent::class)
@Composable
internal fun Help(
  state: HelpState,
  modifier: Modifier = Modifier,
) {
  Scaffold(
    modifier = modifier,
    topBar = {
      HelpTopBar(
        onBack = {
          state.eventSink(HelpEvent.Back)
        },
      )
    },
  ) { paddingValues ->
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = paddingValues,
    ) {
      item {
        SectionTitle(
          title = stringResource(R.string.help_section_title),
        )
      }
    }
  }
}

@Composable
private fun HelpTopBar(
  onBack: () -> Unit,
) {
  TopAppBar(
    title = {
      Text(stringResource(R.string.help_title))
    },
    navigationIcon = {
      IconButton(onClick = onBack) {
        Icon(
          imageVector = Icons.AutoMirrored.Filled.ArrowBack,
          contentDescription = null,
        )
      }
    },
  )
}
