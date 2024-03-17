package io.github.satoshun.pino.feature.help

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.components.SingletonComponent
import io.github.satoshun.pino.feature.help.data.HelpItem
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
      item { Spacer(Modifier.height(8.dp)) }

      item {
        SectionTitle(
          title = stringResource(R.string.help_section_title),
        )
      }

      item { Spacer(Modifier.height(12.dp)) }

      itemsIndexed(state.popularHelp, key = { _, help -> help.id }) { index, help ->
        Entry(
          help = help,
          onClick = {
            // TODO
          },
        )
      }
    }
  }
}

@Composable
private fun Entry(
  help: HelpItem,
  onClick: () -> Unit,
) {
  Row(
    modifier = Modifier
      .padding(vertical = 16.dp)
      .clickable { onClick() },
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Icon(
      imageVector = Icons.Default.Star,
      contentDescription = null,
    )

    Text(
      modifier = Modifier.padding(horizontal = 16.dp),
      text = help.title,
    )
  }
}

@Preview
@Composable
private fun EntryPreview() {
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
