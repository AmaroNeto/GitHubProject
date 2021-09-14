import org.gradle.api.JavaVersion

object Config {
    const val minSdk = 24
    const val compileSdk = 30
    const val targetSdk = 30
    val javaVersion = JavaVersion.VERSION_1_8
    const val buildTools = "30.0.3"
    const val jvmTarget = "1.8"
}

object Versions {
    //A
    const val androidx_core = "1.3.2"
    const val androidx_compact = "1.3.0"
    const val androidx_material = "1.3.0"
    const val androidx_junit = "1.1.2"
    const val androidx_espresso = "3.3.0"
    const val androidx_core_testing = "2.1.0"
    const val androidx_fragment_testing = "1.3.4"

    //G
    const val gradleandroid = "4.2.1"
    const val gradleversions = "1.5.10"
    const val gson = "2.8.7"
    const val glide = "4.12.0"

    //K
    const val android_gradle = "7.1.0-alpha11"
    const val kotlin_gradleplugin = "1.5.10"
    const val koin = "3.0.1-beta-2"

    //M
    const val mockito = "3.2.0"
    const val mockito_inline = "2.13.0"
    const val material_design = "1.5.0-alpha01"

    //N
    const val navigation = "2.3.5"
    const val navigation_plugin = "2.3.5"

    //O
    const val okhttp = "3.12.13"

    //R
    const val rxandroid = "3.0.0"
    const val rxjava3 = "3.0.11"
    const val retrofit = "2.9.0"
    const val retrofit_converse_gson = "2.9.0"
    const val retrofit_rxjava3 = "2.9.0"
}

object Deps {
    //ANDROIDX
    const val androidx_core = "androidx.core:core-ktx:${Versions.androidx_core}"
    const val androidx_compact = "androidx.appcompat:appcompat:${Versions.androidx_compact}"
    const val androidx_material = "com.google.android.material:material:${Versions.androidx_material}"
    const val androidx_junit = "androidx.test.ext:junit:${Versions.androidx_junit}"
    const val androidx_espresso = "androidx.test.espresso:espresso-core:${Versions.androidx_espresso}"
    const val androidx_core_testing =  "androidx.arch.core:core-testing:${Versions.androidx_core_testing}"
    const val androidx_fragment_testing = "androidx.fragment:fragment-testing:${Versions.androidx_fragment_testing}"

    //TEST
    const val junit = "junit:junit:4.+"

    //MATERIAL DESIGN
    const val material = "com.google.android.material:material:${Versions.material_design}"

    // MOCKITO
    const val mockito = "org.mockito.kotlin:mockito-kotlin:${Versions.mockito}"
    const val mockito_inline = "org.mockito:mockito-inline:${Versions.mockito_inline}"

    //KOIN
    const val koin = "io.insert-koin:koin-android:${Versions.koin}"

    //RX
    const val rxandroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxandroid}"
    const val rxjava3 = "io.reactivex.rxjava3:rxjava:${Versions.rxjava3}"

    //RETROFIT
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_converse_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit_converse_gson}"
    const val retrofit_rxjava3 = "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofit_rxjava3}"
    const val okhttp = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    //NAVIGATION
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigation_testing = "androidx.navigation:navigation-testing:${Versions.navigation}"
    const val navigation_dynamic_feature = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigation}"

    //GRADLE
    const val tools_gradleandroid = "com.android.tools.build:gradle:${Versions.android_gradle}"
    const val tools_kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_gradleplugin}"
    const val tools_gradlenavigation = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation_plugin}"

    //GLIDE
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_annotation = "com.github.bumptech.glide:compiler:${Versions.glide}"
}