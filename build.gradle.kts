plugins {
	java
	id("org.springframework.boot") version "3.2.3"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.library"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	runtimeOnly("com.h2database:h2")
	testImplementation("com.h2database:h2")
	testImplementation("org.junit.jupiter:junit-jupiter-api")
	testImplementation("org.hamcrest:hamcrest-core:1.3")
	implementation ("org.springframework.boot:spring-boot-starter-validation")
	implementation ("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
	implementation ("org.springdoc:springdoc-openapi-starter-common:2.3.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
