object Versions {
    const val javaVersion = "23"
    const val kotlin = "2.1.0"
    const val springBoot = "3.4.3"
    const val springCloud = "2024.0.0"
    const val springDependencyManagement = "1.1.4"
    const val openApiGenerator = "7.0.1"

    const val swaggerAnnotations = "2.2.15"
    const val jacksonDatabindNullable = "0.2.6"
    const val springdocOpenApi = "2.2.0"
    const val jwt = "0.11.5"

    const val mapstruct = "1.5.3.Final"

    const val hibernate = "6.6.13.Final"
}

object Deps {
    // Kotlin
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib"

    // Spring
    const val springBootWeb = "org.springframework.boot:spring-boot-starter-web"
    const val springBootWebflux = "org.springframework.boot:spring-boot-starter-webflux"
    const val springBootValidation = "org.springframework.boot:spring-boot-starter-validation"
    const val springBootJpa = "org.springframework.boot:spring-boot-starter-data-jpa"
    const val springBootTest = "org.springframework.boot:spring-boot-starter-test"
    const val springBootSecurity = "org.springframework.boot:spring-boot-starter-security"
    const val springBootActuator = "org.springframework.boot:spring-boot-starter-actuator"
    const val springBootOAuth2Resource = "org.springframework.boot:spring-boot-starter-oauth2-resource-server"
    const val springBootOauth2Client = "org.springframework.boot:spring-boot-starter-oauth2-client"
    const val springBootDataRedis = "org.springframework.boot:spring-boot-starter-data-redis"
    const val springSessionRedis = "org.springframework.session:spring-session-data-redis"

    // Mapper
    const val mapstruct = "org.mapstruct:mapstruct:${Versions.mapstruct}"
    const val mapstructProcessor = "org.mapstruct:mapstruct-processor:${Versions.mapstruct}"

    // Spring Cloud
    const val springCloudGateway = "org.springframework.cloud:spring-cloud-starter-gateway"

    // OpenAPI
    const val swaggerAnnotations = "io.swagger.core.v3:swagger-annotations:${Versions.swaggerAnnotations}"
    const val jacksonDatabindNullable = "org.openapitools:jackson-databind-nullable:${Versions.jacksonDatabindNullable}"
    const val springdocOpenApiWebMvc = "org.springdoc:springdoc-openapi-starter-webmvc-ui:${Versions.springdocOpenApi}"
    const val springdocOpenApiWebflux = "org.springdoc:springdoc-openapi-starter-webflux-ui:${Versions.springdocOpenApi}"

    // Jackson
    const val jacksonKotlin = "com.fasterxml.jackson.module:jackson-module-kotlin"

    // Database
    const val postgresql = "org.postgresql:postgresql"
    const val hibernate = "org.hibernate:hibernate-envers:${Versions.hibernate}"
    const val flywayCore = "org.flywaydb:flyway-core"
    const val flywayPostgresql = "org.flywaydb:flyway-database-postgresql"

    // JWT
    const val jwtApi = "io.jsonwebtoken:jjwt-api:${Versions.jwt}"
    const val jwtImpl = "io.jsonwebtoken:jjwt-impl:${Versions.jwt}"
    const val jwtJackson = "io.jsonwebtoken:jjwt-jackson:${Versions.jwt}"
}