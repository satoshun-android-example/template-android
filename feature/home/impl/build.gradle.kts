plugins {
  alias(libs.plugins.pino.android.library)
  alias(libs.plugins.pino.android.library.compose)
  alias(libs.plugins.pino.android.dagger)
  id("pino.android.circuit")

  alias(libs.plugins.kotlin.serialization)
}

dependencies {
  api(projects.feature.home.public)
  implementation(projects.feature.detail.public)
  implementation(projects.feature.account.public)

  implementation(projects.share)
  implementation(projects.designsystem)

  implementation(libs.bundles.android.ui)
  implementation(libs.bundles.kotlin.android)

  implementation(libs.kotlinx.serialization)

  testImplementation(libs.bundles.test)
}

android {
  namespace = "io.github.satoshun.pino.feature.home"
}
