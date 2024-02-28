plugins {
  id("example.android.library")
  id("example.android.library.compose")
  id("example.android.dagger")
  id("example.android.circuit")

  alias(libs.plugins.kotlin.serialization)
}

dependencies {
  implementation(projects.share)

  implementation(libs.bundles.android.ui)
  implementation(libs.bundles.kotlin.android)

  implementation(libs.kotlinx.serialization)

  testImplementation(libs.bundles.test)
}

android {
  namespace = "io.github.satoshun.example.feature.next"
}
