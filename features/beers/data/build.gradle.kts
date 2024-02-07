plugins {
    alias(libs.plugins.punk.android.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktlint)
}

android {
    namespace = "com.punk.beers.data"
}

dependencies {
    implementation(project(":shared:data"))
    implementation(project(":shared:threading"))

    implementation(libs.square.retrofit2)
    implementation(libs.square.okhttp3.main)
    implementation(libs.square.okhttp3.logging.interceptor)
    implementation(libs.square.moshi.kotlin)

    testImplementation(libs.junit)
    testImplementation(libs.coroutines.test)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
}
