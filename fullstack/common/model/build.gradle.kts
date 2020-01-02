plugins {
  kotlin("multiplatform")
  kotlin("plugin.serialization")
}

kotlin {
  jvm()
  js {
    browser()
    nodejs()
  }

  sourceSets {
    val serializationRuntimeVersion: String by rootProject.extra

    val commonMain by getting {
      dependencies {
        implementation(kotlin("stdlib"))
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:$serializationRuntimeVersion")
      }
    }
    val jvmMain by getting {
      dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationRuntimeVersion")
      }
    }
    val jsMain by getting {
      dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:$serializationRuntimeVersion")
      }
    }
  }
}
