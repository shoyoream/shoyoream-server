plugins {
    id("com.google.protobuf") version "0.9.4"
}

dependencies {
    implementation(project(":core"))

    testImplementation("com.squareup.okhttp3:okhttp:4.9.1")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.1")

    implementation("com.google.protobuf:protobuf-java:3.25.2")
}

dependencyManagement {
    imports {
        val springCloudVersion = "2023.0.0"
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion")
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.19.1"
    }
}
