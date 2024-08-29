pluginManagement {
  includeBuild("build-logic")
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
  }
}

//plugins {
//  id("org.gradle.toolchains.foojay-resolver-convention") version("0.4.0")
//}

dependencyResolutionManagement {
  repositories {
    google()
    mavenCentral()
    maven(url = "https://androidx.dev/storage/compose-compiler/repository/")
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots")
  }
}

rootProject.name = "pino"

include(":share")
include(":designsystem")

include(
  "feature:demo",
)

include(
  ":feature:account:public",
  ":feature:account:impl",
  ":feature:account:demo",
)

include(
  ":feature:detail:public",
  ":feature:detail:impl",
  ":feature:detail:demo",
)
include(
  ":feature:home:impl",
)
include(
  ":feature:help:public",
  ":feature:help:impl",
  ":feature:help:demo",
)

include(":app")

// visual regression testing
include(":vrt:paparazzi")
include(":vrt:compose-screenshot")

// generate baseline profile and benchmark
include(":baselineprofile")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
