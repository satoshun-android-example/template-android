package io.github.satoshun.pino.vrt.composescreenshot

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent

class ComponentPreview(
  private val showkaseBrowserComponent: ShowkaseBrowserComponent
) {
  val content: @Composable () -> Unit = showkaseBrowserComponent.component
  override fun toString(): String = showkaseBrowserComponent.componentKey
}

class ComposeScreenshotTests {
  @Preview(
    device = Devices.PIXEL,
    showBackground = true,
  )
  @Composable
  fun PreviewTests() {
    Column {
      Showkase.getMetadata().componentList.map(::ComponentPreview)
        .sortedBy { it.toString() }
        .forEach { componentPreview ->
          componentPreview.content()
        }
    }
  }
}
