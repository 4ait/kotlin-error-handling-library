import org.jreleaser.model.Active


group = "ru.code4a"
version = file("version").readText().trim()

plugins {
  kotlin("jvm") version "2.0.0"

  `java-library`
  `maven-publish`
  id("org.jreleaser") version "1.12.0"
}

java {
  withJavadocJar()
  withSourcesJar()
}

publishing {
  publications {
    create<MavenPublication>("mavenJava") {
      artifactId = "error-handling"

      from(components["java"])

      pom {
        name = "Error Handling Library"
        description =
          "The `error handling` library provides a simple and intuitive way to handle errors in Kotlin by using sealed classes `Ok` and `Error`. This library helps to differentiate between successful and erroneous outcomes in a type-safe manner."
        url = "https://github.com/4ait/kotlin-errorhandling-library"
        inceptionYear = "2024"
        licenses {
          license {
            name = "The Apache License, Version 2.0"
            url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
          }
        }
        developers {
          developer {
            id = "tikara"
            name = "Evgeniy Simonenko"
            email = "tiikara93@gmail.com"
          }
        }
        scm {
          connection = "scm:git:git://github.com:4ait/kotlin-error-handling-library.git"
          developerConnection = "scm:git:ssh://github.com:4ait/kotlin-error-handling-library.git"
          url = "https://github.com/4ait/kotlin-error-handling-library"
        }
      }
    }
  }
  repositories {
    maven {
      url =
        layout.buildDirectory
          .dir("staging-deploy")
          .get()
          .asFile
          .toURI()
    }
  }
}

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(kotlin("test"))
}

jreleaser {
  project {
    copyright.set("Company 4A")
  }
  gitRootSearch.set(true)
  signing {
    active.set(Active.ALWAYS)
    armored.set(true)
  }
  release {
    github {
      overwrite.set(true)
      branch.set("master")
    }
  }
  deploy {
    maven {
      mavenCentral {
        create("maven-central") {
          active.set(Active.ALWAYS)
          url.set("https://central.sonatype.com/api/v1/publisher")
          stagingRepositories.add("build/staging-deploy")
          retryDelay.set(30)
        }
      }
    }
  }
}

tasks.test {
  useJUnitPlatform()
}
