plugins {
    id("java")
}

group = "io.github.sdxqw"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "io.github.sdxqw.Main"
    }
}

dependencies {
    implementation("org.jetbrains:annotations:24.0.0")
}
