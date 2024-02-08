plugins {
    alias(libs.plugins.punk.android.library)
    alias(libs.plugins.punk.android.library.compose)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.ktlint)
}

android {
    namespace = "com.punk.shared.design.system"
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling.main)
    implementation(libs.androidx.compose.activity)
    implementation(libs.androidx.compose.navigation)
}
