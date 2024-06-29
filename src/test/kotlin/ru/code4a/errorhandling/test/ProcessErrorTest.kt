package ru.code4a.errorhandling.test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ru.code4a.errorhandling.ProcessError

class ProcessErrorTest {
  private class TestProcessError(
    override val message: String
  ) : ProcessError

  @Test
  fun `test ProcessError properties`() {
    val error = TestProcessError("Test error")

    assertEquals("Test error", error.message)
    assertEquals("Test error (at ru.code4a.errorhandling.test.ProcessErrorTest.TestProcessError)", error.qualifiedMessage)
    assertEquals(error.qualifiedMessage, error.detailedMessage)
  }

  @Test
  fun `test messageWithCause`() {
    val cause = TestProcessError("Cause error")
    val error = TestProcessError("Main error")

    val expectedMessage =
      "Main error (at ru.code4a.errorhandling.test.ProcessErrorTest.TestProcessError)\n" +
        "\tCause: Cause error (at ru.code4a.errorhandling.test.ProcessErrorTest.TestProcessError)\n"

    assertEquals(expectedMessage, error.messageWithCause(cause))
  }
}
