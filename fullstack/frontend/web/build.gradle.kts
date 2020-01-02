plugins {
  kotlin("js")
}

repositories {
  jcenter()
  maven { setUrl("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
}

// https://github.com/felipehjcosta/chat-app
kotlin {
  target {
    browser {
      compilations.all {
        kotlinOptions {
          metaInfo = true
          sourceMap = true
          moduleKind = "commonjs"
          main = "call"
        }
      }
      webpackTask {
        runTask {
          // TODO: use dsl after KT-32016 will be fixed
          devServer = org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig.DevServer(
            true, false, true, true, false,
            8081,
            mapOf("/api/v1" to "http://0.0.0.0:8080/"),
            listOf("$projectDir/src/main/resources")
          )
          outputFileName = "web.js"
        }
      }
    }
  }

  sourceSets {
    // https://github.com/mkraynov/kfsad/blob/kotlin-1.3.40-preview/shared/build.gradle
    main {
      dependencies {
        val coroutinesVersion: String by rootProject.extra

        implementation(project(":fullstack:common:model"))
        implementation(project(":fullstack:common:client"))

        implementation(kotlin("stdlib-js"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:$coroutinesVersion")

        implementation("org.jetbrains:kotlin-extensions:1.0.1-pre.89-kotlin-1.3.60")
        implementation("org.jetbrains:kotlin-react:16.9.0-pre.89-kotlin-1.3.60")
        implementation("org.jetbrains:kotlin-react-dom:16.9.0-pre.89-kotlin-1.3.60")

        implementation("org.jetbrains:kotlin-css:1.0.0-pre.89-kotlin-1.3.60")
        implementation("org.jetbrains:kotlin-css-js:1.0.0-pre.89-kotlin-1.3.60")
        implementation("org.jetbrains:kotlin-styled:1.0.0-pre.89-kotlin-1.3.60")

        implementation(npm("core-js", "3.2.0"))
        implementation(npm("react", "16.9.0"))
        implementation(npm("react-dom", "16.9.0"))

        implementation(npm("inline-style-prefixer", "5.1.0"))
        implementation(npm("styled-components", "4.4.0"))
      }
    }
  }
}

// https://github.com/avdim/kotlin-mpp-js-browser/blob/master/build.gradle.kts
tasks.register<Sync>("jsBundle") {
  from(tasks.named("browserWebpack")) {
    rename("(.*)-${version}.js", "$1.js")
    exclude("**/webpack*")
  }
  from(tasks.named("processResources"))
  into("$buildDir/bundle")
}
