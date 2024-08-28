plugins {
  alias(libs.plugins.pino.android.application)
  alias(libs.plugins.pino.android.application.compose)
  alias(libs.plugins.pino.android.dagger)
  alias(libs.plugins.android.app)
}

android {
  namespace = "io.github.satoshun.pino.feature.account.demo"

  defaultConfig {
    applicationId = "io.github.satoshun.pino.account"
    versionCode = 1
    versionName = "1.0"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
    }
  }

  packaging {
    resources.excludes += listOf(
      "META-INF/AL2.0",
      "META-INF/LGPL2.1"
    )
  }
}

dependencies {
  implementation(projects.feature.demo)
  implementation(projects.feature.account.impl)

  implementation(libs.bundles.android.ui)
}
