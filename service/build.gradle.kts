plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

dependencies {
    implementation(project(":api"))

    implementation(Deps.springBootWeb)
    implementation(Deps.springBootJpa)
    implementation(Deps.springBootValidation)
    implementation(Deps.springBootSecurity)
    implementation(Deps.springBootActuator)
    implementation(Deps.jacksonKotlin)
    implementation(Deps.kotlinReflect)
    implementation(Deps.flywayCore)
    implementation(Deps.jwtApi)
    implementation(Deps.springdocOpenApiWebMvc)

    runtimeOnly(Deps.postgresql)
    runtimeOnly(Deps.jwtImpl)
    runtimeOnly(Deps.jwtJackson)

    testImplementation(Deps.springBootTest)
    testImplementation(Deps.h2Database)
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:${Versions.springBoot}")
    }
}

// Configure JPA to handle Kotlin data classes properly
allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}
