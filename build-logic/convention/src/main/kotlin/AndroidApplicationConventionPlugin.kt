import com.android.build.api.dsl.ApplicationExtension
import extensions.configureAndroid
import extensions.configureCompose
import extensions.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.application")
            extensions.configure<ApplicationExtension> {
                configureAndroid()
                configureApplication()
                configureBuildTypes()
                configureCompose()
            }
            configureKotlin()
        }
    }

    private fun ApplicationExtension.configureApplication() {
        defaultConfig {
            targetSdk = 34
            applicationId = "com.punk"
            versionCode = 1
            versionName = "1.0.0"
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    private fun ApplicationExtension.configureBuildTypes() {
        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }
}