/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.satoshun.pino

import com.android.build.api.dsl.CommonExtension
import com.google.devtools.ksp.gradle.KspExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Configure Compose-specific options
 */
internal fun Project.configureAndroidCompose(
  commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
  commonExtension.apply {
    buildFeatures {
      compose = true
    }

    dependencies {
      val bom = libs.findLibrary("compose-bom").get()
      add("implementation", platform(bom))
      add("androidTestImplementation", platform(bom))

      add("implementation", libs.findLibrary("showkase-runtime").get())
      add("ksp", libs.findLibrary("showkase-processor").get())
    }
  }

  extensions.configure<KspExtension> {
    arg("skipPrivatePreviews", "true")
  }

  tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
      freeCompilerArgs.addAll(
        listOf(
          // disable opt-in checks
          "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
          "-opt-in=androidx.compose.foundation.layout.ExperimentalLayoutApi",

          // https://medium.com/androiddevelopers/jetpack-compose-strong-skipping-mode-explained-cbdb2aa4b900
          "-P",
          "plugin:androidx.compose.compiler.plugins.kotlin:experimentalStrongSkipping=true",
        )
      )
    }
  }
  composeCompiler {
    // https://medium.com/androiddevelopers/jetpack-compose-strong-skipping-mode-explained-cbdb2aa4b900
    enableStrongSkippingMode.set(true)

    // apply compose metrics
    val enableMetricsProvider = project.providers.gradleProperty("enableComposeCompilerMetrics")
    val enableMetrics = (enableMetricsProvider.orNull == "true")
    if (enableMetrics) {
      val composeReports = layout.buildDirectory.map { it.dir("reports").dir("compose") }
      reportsDestination.set(composeReports)
      metricsDestination.set(composeReports)
    }

    stabilityConfigurationFile.set(rootProject.file("compose-stability.conf"))
  }
}

private fun Project.composeCompiler(block: ComposeCompilerGradlePluginExtension.() -> Unit) {
  extensions.configure<ComposeCompilerGradlePluginExtension>(block)
}
