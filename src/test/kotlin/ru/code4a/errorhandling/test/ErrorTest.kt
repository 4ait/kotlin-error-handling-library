package ru.code4a.errorhandling.test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ErrorTest {
  @Test
  fun `test Error creation and properties`() {
    val error = ru.code4a.errorhandling.Error("Test error")

    assertTrue(error.isError)
    assertFalse(error.isOk)
    assertEquals("Test error", error.value)
  }

  @Test
  fun `test getOkElseThrow throws exception`() {
    val error = ru.code4a.errorhandling.Error("Test error")

    val exception =
      assertThrows<Exception> {
        error.getOkElseThrow()
      }

    assertEquals("Ok value is not present. Current error: Test error", exception.message)
  }
}
