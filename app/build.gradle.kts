plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
}

android {
    namespace = "com.example.myrecipyapp"
    compileSdk = 34

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.example.myrecipyapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("pl.droidsonroids.gif:android-gif-drawable:1.2.28")

    // Room dependencies
    implementation("androidx.room:room-runtime:2.5.0") // Replace with the latest version
    kapt("androidx.room:room-compiler:2.5.0") // Use kapt for annotation processing
    implementation("androidx.room:room-ktx:2.5.0")

    // Glide dependencies
    implementation("com.github.bumptech.glide:glide:4.14.2")
    kapt("com.github.bumptech.glide:compiler:4.14.2") // Use kapt for Glide's annotation processor

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")


}