// build.gradle.kts (project-level)
plugins {
    kotlin("android") version "1.9.22" apply false
    kotlin("jvm") version "1.9.22" apply false
    id("com.android.application") version "8.2.0" apply false
    id("com.android.library") version "8.2.0" apply false
}

// No need to use plugins block unless needed for custom tools
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Ensure plugin version matches gradle-wrapper
        classpath("com.android.tools.build:gradle:8.10.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")

    }
}

