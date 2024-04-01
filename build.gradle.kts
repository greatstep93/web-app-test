plugins {
    java
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "ru.greatstep"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
implementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("io.projectreactor:reactor-test")
    //    implementation("org.springframework.boot:spring-boot-starter-web") {
//        exclude("org.apache.tomcat.embed","tomcat-embed-core")
//        exclude("org.apache.tomcat.embed","tomcat-embed-el")
//        exclude("org.apache.tomcat.embed","tomcat-embed-websocket")
//    }
//    implementation("org.springframework.boot:spring-boot-starter-jetty")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootJar{
    archiveFileName.set("web-app.test.jar")
}
