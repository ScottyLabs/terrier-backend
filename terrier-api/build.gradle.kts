plugins {
    kotlin("jvm")
    id("org.openapi.generator")
    id("io.spring.dependency-management")
    `java-library`
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:${Versions.springBoot}")
    }
}

// Configure Java toolchain
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(Versions.javaVersion))
    }
}

dependencies {
    implementation(Deps.springBootWeb)
    implementation(Deps.springBootValidation)
    implementation(Deps.swaggerAnnotations)
    implementation(Deps.jacksonDatabindNullable)
    implementation(Deps.jacksonKotlin)
    implementation(Deps.springdocOpenApiWebMvc)
}

// OpenAPI Generator configuration
openApiGenerate {
    generatorName.set("kotlin-spring")
    inputSpec.set("$projectDir/src/main/resources/openapi.yaml")
    outputDir.set("$buildDir/generated")
    apiPackage.set("com.terrier.api")
    modelPackage.set("com.terrier.model")
    modelNameSuffix.set("Model")
    configOptions.set(mapOf(
        "dateLibrary" to "java8",
        "interfaceOnly" to "true",
        "useTags" to "true",
        "annotationLibrary" to "swagger2",
        "documentationProvider" to "springdoc",
        "openApiNullable" to "false",
        "useSpringBoot3" to "true",
        "delegatePattern" to "true"
    ))
    typeMappings.set(mapOf(
        "DateTime" to "Instant",
        "OffsetDateTime" to "Instant",
    ))
    importMappings.set(mapOf(
        "Instant" to "java.time.Instant",
    ))
}

sourceSets {
    main {
        kotlin {
            srcDir("$buildDir/generated/src/main/kotlin")
        }
    }
}

// Ensure generated sources are compiled
tasks.compileKotlin {
    dependsOn(tasks.openApiGenerate)
}

// Create a JAR that includes all dependencies
tasks.register<Jar>("apiJar") {
    archiveClassifier.set("api")
    from(sourceSets.main.get().output)
}

// Publish to Maven local
tasks.register<PublishToMavenLocal>("publishApiToMavenLocal") {
    dependsOn(tasks.named("apiJar"))
}