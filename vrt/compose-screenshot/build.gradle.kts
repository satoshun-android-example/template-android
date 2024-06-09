plugins {
  alias(libs.plugins.pino.android.library)
  alias(libs.plugins.pino.android.library.compose)
  alias(libs.plugins.pino.android.dagger)

  alias(libs.plugins.screenshot)
}

android {
  namespace = "io.github.satoshun.pino.vrt.composescreenshot"

  @Suppress("UnstableApiUsage")
  experimentalProperties["android.experimental.enableScreenshotTest"] = true
}

dependencies {
  implementation(projects.feature.help)

  implementation(libs.bundles.android.ui)

  implementation(libs.ktor.android)
  implementation(libs.ktor.okhttp)
  implementation(libs.ktor.serialization)
  implementation(libs.ktor.negotiation)
  implementation(libs.ktor.json)

  implementation(libs.showkase.runtime)
  ksp(libs.showkase.processor)

  screenshotTestImplementation(libs.compose.tooling)
}
