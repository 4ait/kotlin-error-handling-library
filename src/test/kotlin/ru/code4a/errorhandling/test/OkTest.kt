package ru.code4a.errorhandling.test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import ru.code4a.errorhandling.Ok

class OkTest {
  @Test
  fun `test Ok creation and properties`() {
    val ok = Ok(42)

    assertFalse(ok.isError)
    assertTrue(ok.isOk)
    assertEquals(42, ok.value)
    assertEquals(42, ok.getOkElseThrow())
  }
}
