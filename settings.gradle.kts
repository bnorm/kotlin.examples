pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
  }
  plugins {
    val kotlinVersion = "1.3.61"

    kotlin("jvm") version kotlinVersion
    kotlin("js") version kotlinVersion
    kotlin("multiplatform") version kotlinVersion
  }
}

rootProject.name = "kotlin.examples"
include(":basics")
include(":coroutines")
include(":multiplatform")
