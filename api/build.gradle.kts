dependencies {
    compileOnlyApi("org.jetbrains", "annotations", "24.0.0")
    api("org.bstats", "bstats-bukkit", "3.0.0")
    api("de.tr7zw", "item-nbt-api", "2.11.2") {
        exclude("de.tr7zw", "functional-annotations")
    }
}

// Javadoc JAR task
java {
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.dkim19375.annoying-api"
            artifactId = "api"
            version = project.version.toString()

            from(components["java"])
        }
    }
}