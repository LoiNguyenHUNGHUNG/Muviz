pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

val bandwidthCheckerPath = providers.gradleProperty("bandwidthCheckerPath").orNull
    ?: error(
        "Set -PbandwidthCheckerPath=/path/to/bandwidth-timeout-checker " +
            "to build this case-study branch."
    )
includeBuild(bandwidthCheckerPath)

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Muviz"
include(":app")
