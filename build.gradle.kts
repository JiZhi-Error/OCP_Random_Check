import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.7.10"
    application
    id("com.github.johnrengelman.shadow").version("7.1.2")
}

group = "github.jizhi.ocp.randomcheck"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-jackson:2.9.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("github.jizhi.ocp.randomcheck.Main")
}
tasks.withType<ShadowJar> {
    manifest.attributes.apply {
        put("Implementation-Version", archiveVersion)
        put("Main-Class", "github.jizhi.ocp.randomcheck.Main")
    }
}
