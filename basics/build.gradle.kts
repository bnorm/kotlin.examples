import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm")
}

dependencies {
  implementation(kotlin("stdlib"))
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions.jvmTarget = "1.8"
}
