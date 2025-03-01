plugins {
    kotlin("jvm")
    id("org.openapi.generator")
    `java-library`
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("io.swagger.core.v3:swagger-annotations:2.2.15")
    implementation("org.openapitools:jackson-databind-nullable:0.2.6")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
}

// OpenAPI Generator configuration
openApiGenerate {
    generatorName.set("spring")
    inputSpec.set("$projectDir/src/main/resources/openapi.yaml")
    outputDir.set("$buildDir/generated")
    apiPackage.set("com.hackathon.api")
    modelPackage.set("com.hackathon.model")
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
}

sourceSets {
    main {
        java {
            srcDir("$buildDir/generated/src/main/java")
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