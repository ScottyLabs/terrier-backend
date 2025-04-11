plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    id("org.jetbrains.kotlin.kapt")
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
    implementation(Deps.flywayPostgresql)
    implementation(Deps.hibernate)

    implementation(Deps.jwtApi)
    implementation(Deps.springdocOpenApiWebMvc)

    implementation(Deps.mapstruct)
    kapt(Deps.mapstructProcessor)

    runtimeOnly(Deps.postgresql)
    runtimeOnly(Deps.jwtImpl)
    runtimeOnly(Deps.jwtJackson)

    testImplementation(Deps.springBootTest)
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
