plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.memorize.game.zip"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.memorize.game.zip"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    //noinspection GradleDependency
    implementation("androidx.core:core-ktx:1.1.0")
    //noinspection GradleDependency
    implementation("androidx.appcompat:appcompat:1.1.0")
    //noinspection GradleDependency
    implementation("com.google.android.material:material:1.6.1")

    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

//    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
//    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")

    //noinspection GradleDependency
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    //noinspection GradleDependency
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(project(":learn_animals"))

    implementation("com.appsflyer:af-android-sdk:6.12.3")
    implementation(platform("com.google.firebase:firebase-bom:32.0.0"))
    implementation("com.google.firebase:firebase-database-ktx")
}