@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}
android {
    namespace = libs.versions.packageNameApp.get()
    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        applicationId = libs.versions.packageNameApp.get()
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    dexOptions {
        javaMaxHeapSize ="4g"

    }
    buildFeatures {
        viewBinding = false
        dataBinding = true
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.multidex)
    implementation(libs.androidx.core)
    implementation(libs.androidx.material)
    implementation(libs.androidx.guava)
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.android.ext)
    androidTestImplementation(libs.test.android.espresso)
    implementation(libs.baserecyclerviewadapterhelper)
    implementation(libs.ultimatebarx)
    implementation(libs.bundles.datastore)
    implementation(libs.bundles.androidx.lifecycle.group)
    implementation(libs.bundles.koin)
    implementation(libs.bundles.commons)
    implementation(libs.bundles.logback)
    implementation(libs.bundles.qmui)
    kapt(libs.qmuiteam.arch.compiler)
    implementation(libs.rxkotlin)
    implementation(libs.rxlifecycle.lifecycle.kotlin)

    implementation(libs.gson)
    implementation(libs.recyclerview.flexibledivider)
    implementation(libs.androidx.viewpage2)
    implementation(libs.flowhelper)
    implementation(project(":library"))

}