import com.epages.restdocs.apispec.gradle.OpenApi3Extension
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version Dependency.springBootVersion
    id("io.spring.dependency-management") version "1.1.4"
    id("io.gitlab.arturbosch.detekt") version "1.23.4"
    id("com.epages.restdocs-api-spec") version Dependency.restdocsapiSpecVersion
    kotlin("jvm") version Dependency.kotlinVersion
    kotlin("plugin.spring") version Dependency.kotlinVersion
    kotlin("plugin.jpa") version Dependency.kotlinVersion
    kotlin("plugin.allopen") version Dependency.kotlinVersion
    kotlin("plugin.noarg") version Dependency.kotlinVersion
    kotlin("kapt") version Dependency.kotlinVersion
    jacoco
}

group = "com.attiead.teacher"
version = Constant.VERSION
java.sourceCompatibility = JavaVersion.toVersion(Dependency.targetJvmVersion)

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    maven(uri("https://jitpack.io"))
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${Dependency.springCloudVersion}")
    }
}

dependencies {
    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // MVC
    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-undertow")

    // JPA
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    implementation("mysql:mysql-connector-java:${Dependency.mySQLConnectorVersion}")

    // Validator
    implementation("org.hibernate.validator:hibernate-validator:${Dependency.hibernateValidatorVersion}")

    // jackson
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // logback
    implementation("net.logstash.logback:logstash-logback-encoder:7.2")

    // actuator
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // OpenFeign
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("io.github.openfeign:feign-okhttp:12.2")
    implementation("io.github.openfeign:feign-jackson:12.2")

    // Spring Kafka
    implementation("org.springframework.kafka:spring-kafka")

    // Apache Commons Codec
    implementation("commons-codec:commons-codec:1.15")

    // detekt
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.22.0")

    // Map Struct
    implementation("org.mapstruct:mapstruct:${Dependency.mapStructVersion}")
    kapt("org.mapstruct:mapstruct-processor:${Dependency.mapStructVersion}")

    // Querydsl
    implementation("com.querydsl:querydsl-jpa:${Dependency.querydslVersion}:jakarta")
    kapt("com.querydsl:querydsl-apt:${Dependency.querydslVersion}:jakarta")
    kapt("org.springframework.boot:spring-boot-configuration-processor")


    // swagger-ui
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:${Dependency.openApiStarterWebMvcVersion}")

    // restdocs
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    testImplementation("com.epages:restdocs-api-spec-mockmvc:${Dependency.restdocsapiSpecVersion}")
    testImplementation("com.epages:restdocs-api-spec-model:${Dependency.restdocsapiSpecVersion}")


    // kotest
    testImplementation("io.kotest:kotest-runner-junit5:${Dependency.kotestVersion}")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:${Dependency.kotestSprintExtensions}")
    testImplementation("io.mockk:mockk:${Dependency.mockkVersion}")
    testImplementation("com.ninja-squad:springmockk:${Dependency.springMockkVersion}")

    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
    testImplementation("org.mockito:mockito-inline:5.2.0")
    testImplementation("com.github.javafaker:javafaker:0.12")
    testImplementation("com.h2database:h2")
    testImplementation("org.springframework.cloud:spring-cloud-contract-wiremock")


    implementation(kotlin("stdlib-jdk8"))

    // fixture
    testImplementation("com.appmattus.fixture:fixture:1.2.0")
    testImplementation("com.appmattus.fixture:fixture-javafaker:1.2.0")

}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = Dependency.targetJvmVersion
        }
    }

    withType<Test> {
        useJUnitPlatform()

        testLogging {
            events(TestLogEvent.STANDARD_OUT, TestLogEvent.STANDARD_ERROR)

            showStandardStreams = true
            showCauses = true
            showStackTraces = true
        }

        finalizedBy("jacocoTestReport")
    }

    configure<OpenApi3Extension> {
        setServer(System.getenv("API_SERVER_URL") ?: "http://localhost:8000")
        title = "Attiead Teacher"
        description = "Attiead Teacher API"
        version = "1.0.0"
        format = "yaml"
        outputDirectory = "build/apiSpec"
        outputFileNamePrefix = "swagger"
    }
}

allOpen {
    annotations("jakarta.persistence.Entity", "org.springframework.data.mongodb.core.mapping.Document")
}

noArg {
    annotations("jakarta.persistence.Entity", "org.springframework.data.mongodb.core.mapping.Document")
}

detekt {
    autoCorrect = true
}

jacoco {
    toolVersion = Dependency.jacocoToolVersion
}
