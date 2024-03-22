plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.example.baggish"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.baggish"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //manual dependencies
    implementation("androidx.compose.material:material-icons-extended:1.6.3")

    //view-model
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")

    //navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // Import the BoM for the Firebase platform
//    platform("com.google.firebase:firebase-bom:32.7.2")

    // Declare the dependency for the Firebase Authentication library
    implementation("com.google.firebase:firebase-core:21.1.1")

    //dagger- Hilt
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-android-compiler:2.50")
//    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt ("androidx.hilt:hilt-compiler:1.2.0")
    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Coroutine Lifecycle Scopes
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    //Room
    implementation ("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-paging:2.6.1")

    //Paging
    implementation("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation("androidx.paging:paging-compose:3.2.1")

    //Datastore
    implementation("androidx.datastore:datastore:1.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

//    // Local unit tests
//    testImplementation ("androidx.test:core:1.5.0")
//    testImplementation ("junit:junit:4.13.2")
//    testImplementation ("androidx.arch.core:core-testing:2.2.0")
//    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
//    testImplementation ("com.google.truth:truth:1.1.3")
//    testImplementation ("com.squareup.okhttp3:mockwebserver:4.9.1")
//    testImplementation ("io.mockk:mockk:1.10.5")
//    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.6.3")
//
//    // Instrumentation tests
//    androidTestImplementation ("com.google.dagger:hilt-android-testing:2.50")
//    kaptAndroidTest ("com.google.dagger:hilt-android-compiler:2.50")
//    androidTestImplementation("junit:junit:4.13.2")
//    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
//    androidTestImplementation ("androidx.arch.core:core-testing:2.2.0")
//    androidTestImplementation ("com.google.truth:truth:1.1.3")
//    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation ("androidx.test:core-ktx:1.5.0")
//    androidTestImplementation ("com.squareup.okhttp3:mockwebserver:4.9.1")
//    androidTestImplementation ("io.mockk:mockk-android:1.10.5")
//    androidTestImplementation ("androidx.test:runner:1.5.2")

}