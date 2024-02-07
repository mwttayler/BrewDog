plugins {
    alias(libs.plugins.punk.android.application)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktlint)
}

android {
    namespace = "com.punk"
    packaging {
        resources.excludes.add("META-INF/*")
    }
}

dependencies {
    implementation(project(":shared:data"))
    implementation(project(":shared:design-system"))
    implementation(project(":features:beers:presentation"))
    implementation(project(":features:details:presentation"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.activity)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}
