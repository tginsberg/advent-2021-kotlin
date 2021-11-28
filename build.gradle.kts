/*
 * Copyright (c) 2021 by Todd Ginsberg
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
}

repositories {
   mavenCentral()
}

dependencies {
    testApi("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("org.assertj:assertj-core:3.21.0")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
    test {
        useJUnitPlatform()
    }
}
