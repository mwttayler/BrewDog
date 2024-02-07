import com.android.build.gradle.LibraryExtension
import extensions.configureAndroid
import extensions.configureCompose
import extensions.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<LibraryExtension> { configureCompose() }
        }
    }
}