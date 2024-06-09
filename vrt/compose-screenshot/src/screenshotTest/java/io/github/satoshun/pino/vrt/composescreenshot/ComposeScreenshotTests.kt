package io.github.satoshun.pino.vrt.composescreenshot

import androidx.compose.runtime.Composable
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import com.google.testing.junit.testparameterinjector.TestParameterValuesProvider
import org.junit.Test
import org.junit.runner.RunWith

class ComponentPreview(
  private val showkaseBrowserComponent: ShowkaseBrowserComponent
) {
  val content: @Composable () -> Unit = showkaseBrowserComponent.component
  override fun toString(): String = showkaseBrowserComponent.componentKey
}

@RunWith(TestParameterInjector::class)
class ComposeScreenshotTests {

  object PreviewProvider : TestParameterValuesProvider() {
    override fun provideValues(context: Context?): MutableList<*> =
      Showkase.getMetadata().componentList.map(::ComponentPreview).toMutableList()
  }

  @Test
  fun previewTests(
    @TestParameter(valuesProvider = PreviewProvider::class) componentPreview: ComponentPreview,
  ) {
//    paparazzi.snapshot {
//      CompositionLocalProvider(
//        LocalInspectionMode provides true,
//        LocalDensity provides Density(
//          density = LocalDensity.current.density,
//          fontScale = 1.0f,
//        )
//      ) {
//        Box {
//          componentPreview.content()
//        }
//      }
//    }
  }
}
