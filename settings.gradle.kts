pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "BrewDog"
include(
    ":app",
    // # Features
    // ## Beers
    ":features:beers:presentation",
    ":features:beers:data",
    // ## Details
    ":features:details:presentation",
    ":features:details:data",
    // # Shared
    ":shared:data",
    ":shared:threading",
    ":shared:design-system"
)
