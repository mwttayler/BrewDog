plugins {
    alias(libs.plugins.punk.android.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktlint)
}

android {
    namespace = "com.punk.shared.threading"
}

dependencies {
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.test)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(libs.junit)
    implementation(libs.coroutines.test)
}
