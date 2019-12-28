plugins {
  val kotlinVersion = "1.3.61"

  kotlin("jvm") version kotlinVersion apply false
  kotlin("js") version kotlinVersion apply false
  kotlin("multiplatform") version kotlinVersion apply false
  kotlin("plugin.serialization") version kotlinVersion apply false
}

allprojects {
  group = "com.bnorm.examples.kotlin"
  version = "0.1-SNAPSHOT"

  repositories {
    mavenCentral()
    maven { setUrl("https://kotlin.bintray.com/kotlinx") }
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
  }
}

tasks.register("runService") {
  dependsOn(tasks.findByPath(":fullstack:backend:service:run"))
}

tasks.register("runWeb") {
  dependsOn(tasks.findByPath(":fullstack:frontend:web:run"))
}
