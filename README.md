# ErrorHandling Library

The `errorhandling` library provides a simple and intuitive way to handle errors in Kotlin by using sealed classes `Ok` and `Error`. This library helps to differentiate between successful and erroneous outcomes in a type-safe manner.

## Installation

Add the following dependency to your `build.gradle.kts` file:

```kotlin
dependencies {
    implementation("ru.foura:errorhandling:1.0.0")
}
```

Or, if you are using Maven, add the following to your `pom.xml`:

```xml
<dependency>
    <groupId>ru.foura</groupId>
    <artifactId>errorhandling</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

### Basic Usage

The library provides two main classes: `Ok` and `Error`, both inheriting from `OkOrError`. Here are some basic examples of how to use them:

#### Creating Instances

```kotlin
import ru.foura.errorhandling.*

fun main() {
    val success: OkOrError<Int, String> = asOk(42)
    val failure: OkOrError<Int, String> = asError("An error occurred")

    println("Success is OK: ${success.isOk}") // prints: Success is OK: true
    println("Failure is Error: ${failure.isError}") // prints: Failure is Error: true
}
```

#### Extension Functions

The library provides convenient extension functions to convert any value into `Ok` or `Error`.

```kotlin
import ru.foura.errorhandling.*

fun main() {
    val success = 42.asOk()
    val failure = "An error occurred".asError()

    println("Success is OK: ${success.isOk}") // prints: Success is OK: true
    println("Failure is Error: ${failure.isError}") // prints: Failure is Error: true
}
```

#### Working with `OkOrError`

You can use the `OkOrError` class to handle different outcomes and perform actions accordingly.

```kotlin
import ru.foura.errorhandling.*

fun processResult(result: OkOrError<Int, String>) {
    if (result.isOk) {
        val value = result.getOkElseThrow()
        println("Operation successful: $value")
    } else {
        println("Operation failed with error: ${(result as Error).value}")
    }
}

fun main() {
    val success = 42.asOk()
    val failure = "An error occurred".asError()

    processResult(success)
    processResult(failure)
}
```

#### Using `when` for Handling Results

The `when` expression in Kotlin can be effectively used to handle `Ok` and `Error` results. Here's an example:

```kotlin
import ru.foura.errorhandling.*

fun processWithWhen(result: OkOrError<Int, String>) {
    when (result) {
        is Ok -> {
            val value = result.value
            println("Operation successful: $value")
        }
        is Error -> {
            val error = result.value
            println("Operation failed with error: $error")
        }
    }
}

fun main() {
    val success = 42.asOk()
    val failure = "An error occurred".asError()

    processWithWhen(success)
    processWithWhen(failure)
}
```
