plugins {
    id("java")
}

group = "de.shadowdara.fstools"
version = "0.1.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "de.shadowdara.fstools.Main"  // Deine Main-Klasse hier anpassen
    }
}
