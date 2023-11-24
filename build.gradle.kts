buildscript {
  repositories {
    google()
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
  }
}

plugins {
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.serialization) apply false

  alias(libs.plugins.android.app) apply false
  alias(libs.plugins.android.library) apply false

  alias(libs.plugins.ksp) apply false
  alias(libs.plugins.dagger.hilt) apply false
  alias(libs.plugins.paparazzi) apply false
  alias(libs.plugins.dependencyAnalysis)
  alias(libs.plugins.sortDependencies)
}

allprojects {
  repositories {
    google()
    mavenCentral()
    mavenLocal()
    maven("https://androidx.dev/storage/compose-compiler/repository/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
  }
}
