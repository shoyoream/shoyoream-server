import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
    id("com.graphql_java_generator.graphql-gradle-plugin") version "1.18.6"
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.spring") version "1.9.0"
    kotlin("plugin.jpa") version "1.9.0"

    id("org.jlleitschuh.gradle.ktlint") version "11.3.2"
    id("org.jlleitschuh.gradle.ktlint-idea") version "11.3.2"

    jacoco
}

allprojects {
    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }
}

subprojects {
    apply {
        plugin("kotlin")
        plugin("org.springframework.boot")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.jpa")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("kotlin-spring")
        plugin("io.spring.dependency-management")
        apply(plugin = "org.jlleitschuh.gradle.ktlint")
        apply(plugin = "jacoco")
    }

    group = "shoyoream.server"
    version = "0.0.1-SNAPSHOT"
    java.sourceCompatibility = JavaVersion.VERSION_17

    jacoco {
        toolVersion = "0.8.8"
    }

    tasks.jacocoTestReport {
        dependsOn(tasks.test)
        reports {
            html.required = true
            xml.required = false
            csv.required = false

            html.outputLocation = file("build/reports/jacoco/index.html")
        }

        val excludes = listOf(
            "shoyoream/server/shoyoreamapplication/core/infra/config"
        )

        classDirectories.setFrom(
            sourceSets.main.get().output.asFileTree.matching { exclude(excludes) }
        )

        finalizedBy("jacocoTestCoverageVerification")
    }

    tasks.jacocoTestCoverageVerification {
        violationRules {
            rule {
                limit {
                    minimum = "0.30".toBigDecimal()
                }
            }

            rule {
                enabled = true
                element = "CLASS"

                // 브랜치 커버리지를 최소한 90% 만족시켜야 한다.
                limit {
                    counter = "BRANCH"
                    value = "COVEREDRATIO"
                    minimum = "0.90".toBigDecimal()
                }

                // 라인 커버리지를 최소한 80% 만족시켜야 한다.
                limit {
                    counter = "LINE"
                    value = "COVEREDRATIO"
                    minimum = "0.80".toBigDecimal()
                }

                // 빈 줄을 제외한 코드의 라인수를 최대 200라인으로 제한한다.
                limit {
                    counter = "LINE"
                    value = "TOTALCOUNT"
                    maximum = "200".toBigDecimal()
                }

                // 커버리지 체크를 제외할 클래스들
                excludes = listOf(
                    "*.dto.*"
                )
            }
        }

        val excludes = listOf(
            "shoyoream/server/shoyoreamapplication/core/infra/config"
        )

        classDirectories.setFrom(
            sourceSets.main.get().output.asFileTree.matching { exclude(excludes) }
        )
    }

    val testCoverage by tasks.registering {
        group = "verification"
        description = "Runs the unit tests with coverage"

        dependsOn(
            ":test",
            ":jacocoTestReport",
            ":jacocoTestCoverageVerification"
        )

        tasks["jacocoTestReport"].mustRunAfter(tasks["test"])
        tasks["jacocoTestCoverageVerification"].mustRunAfter(tasks["jacocoTestReport"])
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-graphql")
        implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:13.0.1")
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter-validation")
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-webflux")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

        implementation("org.springframework.kafka:spring-kafka")
        implementation("org.apache.kafka:kafka-clients:2.5.0")

        val jdslVersion = "2.2.1.RELEASE"
        implementation("com.linecorp.kotlin-jdsl:hibernate-kotlin-jdsl-jakarta:$jdslVersion")
        implementation("org.hibernate:hibernate-core:6.2.4.Final")
        implementation("com.linecorp.kotlin-jdsl:spring-data-kotlin-jdsl-starter-jakarta:$jdslVersion")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("io.projectreactor:reactor-test")
        testImplementation("org.springframework.security:spring-security-test")

        val kotestVersion = "4.6.0"
        // mockk
        testImplementation("io.mockk:mockk:1.9.3")
        // kotest
        testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
        testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
        testImplementation("io.kotest:kotest-property:$kotestVersion")
        // kotest-extension-spring
        testImplementation("io.kotest:kotest-extensions-spring:4.4.3")
    }

    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {
        additionalEditorconfigFile.set(file(".editorconfig"))

        filter {
            exclude("./.gradle/**")
            include("**/kotlin/**")
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "17"
        }
    }

    tasks.register("prepareKotlinBuildScriptModel")

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

project(":core") {
    val jar: Jar by tasks
    val bootJar: BootJar by tasks

    jar.enabled = true
    bootJar.enabled = false
}

project(":product-application") {
    tasks.bootJar {
        archiveFileName.set("product-application.jar")
    }
}

project(":order-application") {
    tasks.bootJar {
        archiveFileName.set("order-application.jar")
    }
}

project(":payment-application") {
    tasks.bootJar {
        archiveFileName.set("payment-application.jar")
    }
}

project(":shipping-application") {
    tasks.bootJar {
        archiveFileName.set("shipping-application.jar")
    }
}

val jar: Jar by tasks
val bootJar: BootJar by tasks

jar.enabled = true
bootJar.enabled = false
