plugins {
    id("org.springframework.boot") version Versions.springBoot apply false
    id("io.spring.dependency-management") version Versions.springDependencyManagement apply false
    kotlin("jvm") version Versions.kotlin apply false
    kotlin("plugin.spring") version Versions.kotlin apply false
    kotlin("plugin.jpa") version Versions.kotlin apply false
    id("org.openapi.generator") version Versions.openApiGenerator apply false
}

allprojects {
    group = "com.terrier"
    version = "1.0.0"

    repositories {
        mavenCentral()
    }
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
}