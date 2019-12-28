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
    val coroutinesVersion = "1.3.3"
    val serializationRuntimeVersion = "0.14.0"

    val commonMain by getting {
      dependencies {
        implementation(kotlin("stdlib"))

        api(project(":fullstack:common:model"))

        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${coroutinesVersion}")
      }
    }
    val jvmMain by getting {
      dependencies {
        implementation(kotlin("stdlib-jdk8"))

        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:${coroutinesVersion}")

        api("com.squareup.retrofit2:retrofit:2.6.1")
        implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.4.0")
      }
    }
    val jsMain by getting {
      dependencies {
        implementation(kotlin("stdlib-js"))

        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:${coroutinesVersion}")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:$serializationRuntimeVersion")
      }
    }
  }
}
