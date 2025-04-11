plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    implementation(Deps.springBootWebflux)
    implementation(Deps.springCloudGateway)
    implementation(Deps.springBootSecurity)
    implementation(Deps.springBootOauth2Client)
    implementation(Deps.springBootActuator)

    implementation(Deps.springBootDataRedis)
    implementation(Deps.springSessionRedis)

    runtimeOnly(Deps.jwtImpl)
    runtimeOnly(Deps.jwtJackson)

    testImplementation(Deps.springBootTest)
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${Versions.springCloud}")
        mavenBom("org.springframework.boot:spring-boot-dependencies:${Versions.springBoot}")
    }
}


tasks.register("findMvcDependency") {
    doLast {
        println("Checking for MVC dependencies in the project...")

        val webMvcDependencyExists = configurations.runtimeClasspath.get().resolvedConfiguration.resolvedArtifacts.any {
            it.moduleVersion.id.group == "org.springframework" && it.moduleVersion.id.name == "spring-webmvc" ||
                    it.moduleVersion.id.group == "org.springframework.boot" && it.moduleVersion.id.name == "spring-boot-starter-web"
        }

        println("WebMVC found: $webMvcDependencyExists")

        println("\nAll Dependencies:")
        configurations.runtimeClasspath.get().resolvedConfiguration.resolvedArtifacts.forEach {
            println("${it.moduleVersion.id.group}:${it.moduleVersion.id.name}:${it.moduleVersion.id.version}")
        }
    }
}