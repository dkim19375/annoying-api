plugins {
    `java-library`
    `maven-publish`
}

group = "io.github.dkim19375"
version = "3.0.2-SNAPSHOT"

subprojects {
    version = "3.0.2-SNAPSHOT"
    group = "io.github.dkim19375"

    apply(plugin = "java-library")
    apply(plugin = "maven-publish")

    repositories {
        mavenCentral() // org.spigotmc:spigot, net.md-5:bungeecord-api (api)
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots") // org.spigotmc:spigot-api
        maven("https://oss.sonatype.org/content/repositories/snapshots") // org.spigotmc:spigot-api
        maven("https://repo.extendedclip.com/content/repositories/placeholderapi") // me.clip:placeholderapi
        maven("https://repo.codemc.io/repository/maven-public/") // de.tr7zw:item-nbt-api
    }

    dependencies {
        compileOnly("org.spigotmc", "spigot-api", "1.8.8-R0.1-SNAPSHOT")
        compileOnly("me.clip", "placeholderapi", "2.11.3")
    }

    // Set Java version
    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    tasks {
        // Text encoding
        compileJava {
            options.encoding = "UTF-8"
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.dkim19375"
            artifactId = "annoying-api"
            version = project.version.toString()

            from(components["java"])
        }
    }
}