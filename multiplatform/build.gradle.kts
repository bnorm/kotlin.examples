plugins {
  kotlin("multiplatform")
}

kotlin {
  jvm()
  js {
    nodejs {
      testTask {
        useMocha()
      }
    }
  }

  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation(kotlin("stdlib"))
      }
    }
    val commonTest by getting {
      dependencies {
        implementation(kotlin("test-annotations-common"))
        implementation(kotlin("test-common"))
      }
    }
    val jvmTest by getting {
      dependencies {
        implementation(kotlin("test"))
        implementation(kotlin("test-junit"))
      }
    }
    val jsTest by getting {
      dependencies {
        implementation(kotlin("test-js"))
      }
    }
  }
}
