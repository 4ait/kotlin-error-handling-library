package ru.code4a.errorhandling.test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ru.code4a.errorhandling.Ok
import ru.code4a.errorhandling.asError
import ru.code4a.errorhandling.asOk

class OkOrErrorTest {
  @Test
  fun `test asError function`() {
    val error = asError("Test error")
    assertTrue(error is ru.code4a.errorhandling.Error)
    assertEquals("Test error", error.value)
  }

  @Test
  fun `test asOk function`() {
    val ok = asOk(42)
    assertTrue(ok is Ok)
    assertEquals(42, ok.value)
  }

  @Test
  fun `test TypedAsError extension function`() {
    val error = "Test error".asError()
    assertTrue(error is ru.code4a.errorhandling.Error)
    assertEquals("Test error", error.value)
  }

  @Test
  fun `test TypedAsOk extension function`() {
    val ok = 42.asOk()
    assertTrue(ok is Ok)
    assertEquals(42, ok.value)
  }
}
