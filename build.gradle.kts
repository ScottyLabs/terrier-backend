plugins {
    kotlin("jvm") version "1.6.10" apply false
    id("org.springframework.boot") version "2.6.0" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
}

allprojects {
    repositories {
        mavenCentral()
    }
}
