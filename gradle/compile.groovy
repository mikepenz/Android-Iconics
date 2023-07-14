apply plugin: "kotlin-android"

android {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
        apiVersion = "1.8"
        languageVersion = "1.8"
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}

kotlin {
    jvmToolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}