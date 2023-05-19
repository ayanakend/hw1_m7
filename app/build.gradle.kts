plugins {
    id (Plugins.AGP.application);
    id (Plugins.Kotlin.android);
    id (Plugins.Kotlin.kapt);
    id (Plugins.DaggerHilt.hilt);
}

android {
    namespace = "com.example.lesson1month8"
    compileSdk = AppConfig.compileSdk
    defaultConfig {
        applicationId = "com.example.lesson1month8"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.TestInstrumentation
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
        jvmTarget = AppConfig.jvmTarget
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {//

    implementation (Deps.Ui.core)
    implementation (Deps.Ui.appcompat)
    implementation (Deps.Ui.material)
    implementation (Deps.Ui.constraint)
    testImplementation (Deps.Ui.junit)
    androidTestImplementation (Deps.Ui.extJunit)
    androidTestImplementation (Deps.Ui.espresso)


    // Room
    implementation(Deps.Room.runtime)
    kapt(Deps.Room.compiler)
    implementation(Deps.Room.ktx)

    // Coroutines
    implementation(Deps.Coroutines.android)
    implementation(Deps.Coroutines.core)

    // Hilt
    implementation (Deps.DaggerHilt.android)
    implementation (Deps.DaggerHilt.core)
    kapt (Deps.DaggerHilt.compiler)

    //navgraph

    implementation (Deps.NavGraph.fragment)
    implementation (Deps.NavGraph.ui)

    // Lifecycle
    implementation (Deps.Lifecycle.viewModel)
    implementation (Deps.Lifecycle.runtime)

    //Fragment
    implementation (Deps.Ui.fragment)
}