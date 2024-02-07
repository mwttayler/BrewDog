plugins {
    alias(libs.plugins.punk.android.library)
    alias(libs.plugins.punk.android.library.compose)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktlint)
}

android {
    namespace = "com.punk.beers.presentation"
}

dependencies {
    implementation(project(":shared:threading"))
    implementation(project(":shared:design-system"))
    implementation(project(":features:beers:data"))

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling.main)
    implementation(libs.androidx.compose.activity)
    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.coil)
    implementation(libs.placeholder)

    testImplementation(libs.junit)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.turbine)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}
