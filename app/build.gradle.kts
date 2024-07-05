plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.navigationSafeArgs)
}

android {
    namespace = "com.yash.opttera2"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.yash.opttera2"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    val nav_version = "2.7.7"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")


    // Material Component Theme
    implementation("com.google.android.material:material:1.3.0")
    //Dot Indicator
    implementation("com.tbuonomo:dotsindicator:4.3")

    implementation("com.intuit.sdp:sdp-android:1.0.6")
    implementation ("com.intuit.ssp:ssp-android:1.0.6")
    // country code Picker
    implementation("com.hbb20:ccp:2.6.0")
    implementation("com.googlecode.libphonenumber:libphonenumber:8.12.34")
    //BarCode
    implementation("com.journeyapps:zxing-android-embedded:4.2.0")



}