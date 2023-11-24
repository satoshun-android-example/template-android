plugins {
  id("example.android.library")

  alias(libs.plugins.kotlin.serialization)
}

dependencies {
  implementation(libs.ktor.android)
  implementation(libs.ktor.okhttp)
  implementation(libs.ktor.serialization)
  implementation(libs.ktor.negotiation)
  implementation(libs.ktor.json)
}

android {
  namespace = "io.github.satoshun.example.share"
}
