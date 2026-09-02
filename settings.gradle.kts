pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

val bandwidthCheckerPath = providers.gradleProperty("bandwidthCheckerPath").orNull
if (bandwidthCheckerPath != null) {
    includeBuild(bandwidthCheckerPath)
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Muviz"
include(":app")
