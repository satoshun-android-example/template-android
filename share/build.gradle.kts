plugins {
  id("example.android.library")
  id("example.android.library.compose")
  id("example.android.dagger")

  alias(libs.plugins.kotlin.serialization)
}

dependencies {
  implementation(libs.bundles.android.ui)
  implementation(libs.bundles.kotlin.android)

  implementation(libs.kotlinx.serialization)

  implementation(libs.ktor.android)
  implementation(libs.ktor.okhttp)
  implementation(libs.ktor.serialization)
  implementation(libs.ktor.negotiation)
  implementation(libs.ktor.json)

  testImplementation(libs.bundles.test)
}

android {
  namespace = "io.github.satoshun.example.share"
}
