import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm")
}

dependencies {
  val coroutinesVersion = "1.3.3"

  implementation(kotlin("stdlib"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$coroutinesVersion")
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions.jvmTarget = "1.8"
}
