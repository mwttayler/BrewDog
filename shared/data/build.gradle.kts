plugins {
    alias(libs.plugins.punk.android.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.punk.shared.data"
}

dependencies {
    implementation(libs.square.retrofit2)
    implementation(libs.square.okhttp3.main)
    implementation(libs.square.okhttp3.logging.interceptor)
    implementation(libs.square.moshi.kotlin)
    implementation(libs.square.moshi.retrofit)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    ksp(libs.square.moshi.codegen)
}
