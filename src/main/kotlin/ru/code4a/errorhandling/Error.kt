package ru.code4a.errorhandling

class Error<out ErrorType>(
  val value: ErrorType
) : OkOrError<Nothing, ErrorType>() {
  override val isError: Boolean
    get() = true
  override val isOk: Boolean
    get() = false

  override fun getOkElseThrow(): Nothing = throw Exception("Ok value is not present. Current error: $value")
}
