plugins {
	java
	id("org.springframework.boot") version "3.2.5"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "me.dio"
version = "0.0.2-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2023.0.1"

// Spring Initializer: https://start.spring.io/#!type=gradle-project-kotlin&language=java&platformVersion=3.2.5&packaging=jar&jvmVersion=21&groupId=dio.me&artifactId=sdw24&name=sdw24&description=Demo%20project%20for%20Spring%20Boot&packageName=dio.me.sdw24&dependencies=data-jdbc,web,h2,cloud-feign
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
	// OpenAPI (Swagger): https://springdoc.org/#getting-started
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
