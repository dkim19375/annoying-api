dependencies {
    implementation(project(":api"))
}

// Replace '${name}' and '${version}' in resource files
tasks.processResources {
    inputs.property("name", project.name)
    inputs.property("version", version)
    filesMatching("**/*.yml") {
        expand("name" to project.name, "version" to version)
    }
}