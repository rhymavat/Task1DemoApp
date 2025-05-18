pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    plugins {
        id("com.android.application") version "8.10.0"
        id("org.jetbrains.kotlin.android") version "1.9.20"
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io") // Optional, if you use GitHub dependencies
    }
}

rootProject.name = "Task1DemoApp"
include(":app")


