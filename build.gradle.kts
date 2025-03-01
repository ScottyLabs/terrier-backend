plugins {
    id("org.springframework.boot") version "3.2.0" apply false
    id("io.spring.dependency-management") version "1.1.4" apply false
    kotlin("jvm") version "1.9.20" apply false
    kotlin("plugin.spring") version "1.9.20" apply false
    kotlin("plugin.jpa") version "1.9.20" apply false
    id("org.openapi.generator") version "7.0.1" apply false
}

allprojects {
    group = "com.hackathon"
    version = "1.0.0"

    repositories {
        mavenCentral()
    }
}