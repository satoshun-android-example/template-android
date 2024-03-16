package io.github.satoshun.pino.feature.account

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.slack.circuit.codegen.annotations.CircuitInject
import dagger.hilt.components.SingletonComponent

@CircuitInject(AccountScreen::class, SingletonComponent::class)
@Composable
internal fun Account(
  state: AccountState,
  modifier: Modifier = Modifier,
) {
  Scaffold(
    modifier = modifier,
    topBar = {
      AccountTopBar()
    },
  ) { paddingValues ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues),
      contentAlignment = Alignment.Center,
    ) {
    }
  }
}

@Composable
private fun AccountTopBar() {
  TopAppBar(
    title = {
      Text(stringResource(R.string.account_title))
    },
    navigationIcon = {
      Icon(
        imageVector = Icons.AutoMirrored.Default.ArrowBack,
        contentDescription = null,
      )
    },
  )
}
