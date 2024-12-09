plugins {
    alias(libs.plugins.android.application)
    //id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.hfad.csementorlearningapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.hfad.csementorlearningapp"
        minSdk = 24
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.storage)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    implementation(libs.recyclerview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation ("com.google.android.material:material:1.0.0")
    implementation ("androidx.navigation:navigation-runtime:2.0.0")
    implementation("androidx.navigation:navigation-fragment:2.1.0")
    implementation ("androidx.navigation:navigation-ui:2.1.0")
    implementation ("androidx.cardview:cardview:1.0.0")

    implementation(platform("com.google.firebase:firebase-bom:33.5.1"))
    implementation("com.google.firebase:firebase-analytics")

    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation ("com.joanzapata.pdfview:android-pdfview:1.0.4@aar")
    //annotationProcessor ("com.github.bumptech.glide:compiler:4.15.1")
    implementation ("de.hdodenhof:circleimageview:3.0.1")
    implementation ("com.squareup.picasso:picasso:2.71828")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.cardview:cardview:1.0.0")




    //implementation (libs.android.pdf.viewer)
   // implementation ("com.github.barteksc:android-pdf-viewer:3.2.0-beta.1")





}