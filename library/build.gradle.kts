plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("maven-publish")
}

android {
    namespace =libs.versions.packageNameLibrary.get()
    compileSdk =libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()





    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

    }
    compileOptions {
        sourceCompatibility= JavaVersion.VERSION_17
        targetCompatibility= JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core)
    implementation(libs.androidx.material)

}
afterEvaluate {
    publishing{
        publications {
           register<MavenPublication>("release") {
                groupId = "com.github.ethann-tech"
                artifactId = "Zincum"
                version = "1.0.0"
            }
        }
    }
}
