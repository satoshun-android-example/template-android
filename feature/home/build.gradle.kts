plugins {
  id("example.android.library")
  id("example.android.library.compose")
  id("example.android.dagger")

  alias(libs.plugins.kotlin.serialization)
}

dependencies {
  ksp(libs.circuit.codegen)

  implementation(projects.share)

  implementation(libs.bundles.android.ui)
  implementation(libs.bundles.kotlin.android)

  implementation(libs.circuit.codegenAnnotations)

  implementation(libs.kotlinx.serialization)

  testImplementation(libs.bundles.test)
}

ksp {
  arg("circuit.codegen.mode", "hilt")
}

android {
  namespace = "io.github.satoshun.example.feature.home"
}
