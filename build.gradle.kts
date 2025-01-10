plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.maxjang"
version = "1.0"

// 버전 관리
val kotlinVersion = "1.9.25"
val springBootVersion = "3.4.1"
val springDependencyManagementVersion = "1.1.7"
val springdocVersion = "2.2.0"
val javaVersion = 17
val playwrightVersion = "1.49.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(javaVersion)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.microsoft.playwright:playwright:${playwrightVersion}")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:$springdocVersion")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}
