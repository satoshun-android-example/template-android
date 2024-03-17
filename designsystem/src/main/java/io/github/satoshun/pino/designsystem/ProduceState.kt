package io.github.satoshun.pino.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.ProduceStateScope
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.CoroutineContext

@Composable
fun <T> produceStateSaveable(
  initialValue: T,
  producer: suspend ProduceStateScope<T>.() -> Unit,
): State<T> {
  val result = rememberSaveable { mutableStateOf(initialValue) }
  LaunchedEffect(Unit) {
    ProduceStateScopeImpl(result, coroutineContext).producer()
  }
  return result
}

@Composable
fun <T> produceStateSaveable(
  initialValue: T,
  key1: Any?,
  producer: suspend ProduceStateScope<T>.() -> Unit,
): State<T> {
  val result = rememberSaveable { mutableStateOf(initialValue) }
  LaunchedEffect(key1) {
    ProduceStateScopeImpl(result, coroutineContext).producer()
  }
  return result
}

private class ProduceStateScopeImpl<T>(
  state: MutableState<T>,
  override val coroutineContext: CoroutineContext
) : ProduceStateScope<T>, MutableState<T> by state {

  override suspend fun awaitDispose(onDispose: () -> Unit): Nothing {
    try {
      suspendCancellableCoroutine<Nothing> { }
    } finally {
      onDispose()
    }
  }
}
