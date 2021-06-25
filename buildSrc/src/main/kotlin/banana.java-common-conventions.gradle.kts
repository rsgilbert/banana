/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    // Java library
    // https://www.jetbrains.com/help/idea/add-a-gradle-library-to-the-maven-repository.html#edit_build_script
    `java-library`
    `maven-publish`
}


repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    constraints {
        // Define dependency versions as constraints
        implementation("org.apache.commons:commons-text:1.9")
    }

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.5.1")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    // Add assertj library for extra testing
    // see: https://joel-costigliola.github.io/assertj/assertj-core-quick-start.html
    testImplementation("org.assertj:assertj-core:3.11.1")

    // hamcrest for extra testing
    // see: http://hamcrest.org/JavaHamcrest/distributables
    testImplementation("org.hamcrest:hamcrest:2.2")
}

tasks.test {
    // Use junit platform for unit tests.
    useJUnitPlatform()
}
