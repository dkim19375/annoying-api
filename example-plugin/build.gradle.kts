dependencies {
    implementation(project(":api", configuration = "shadow"))
}

// Relocate the AnnoyingAPI package
tasks {
    shadowJar {
        relocate("xyz.srnyx.annoyingapi", "xyz.srnyx.annoyingexample.annoyingapi")
    }
}
