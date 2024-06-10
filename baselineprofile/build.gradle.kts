plugins {
  alias(libs.plugins.android.test)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.baselineprofile)
}

android {
  namespace = "io.github.satoshun.pino.baselineprofile"
  compileSdk = 34

  defaultConfig {
    minSdk = 28
    targetSdk = 34
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }

  @Suppress("UnstableApiUsage")
  testOptions.managedDevices.devices {
    create<com.android.build.api.dsl.ManagedVirtualDevice>("pixel6Api33") {
      device = "Pixel 6"
      apiLevel = 33
      systemImageSource = "aosp"
    }
  }

  targetProjectPath = ":app"
  @Suppress("UnstableApiUsage")
  experimentalProperties["android.experimental.self-instrumenting"] = true
}

@Suppress("UnstableApiUsage")
baselineProfile {
  managedDevices += "pixel6Api33"
  useConnectedDevices = false

  enableEmulatorDisplay = false
}

dependencies {
  implementation(libs.ext.junit)
  implementation(libs.android.test.espresso)
  implementation(libs.uiautomator)
  implementation(libs.benchmark.macro.junit4)
}
