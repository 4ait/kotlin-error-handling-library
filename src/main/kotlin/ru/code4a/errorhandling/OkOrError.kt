package ru.code4a.errorhandling

sealed class OkOrError<out OkType, out ErrorType> {
  abstract val isError: Boolean
  abstract val isOk: Boolean

  abstract fun getOkElseThrow(): OkType
}

fun <ErrorType> asError(value: ErrorType): Error<ErrorType> = Error(value)

fun <OkType> asOk(value: OkType): Ok<OkType> = Ok(value)

@JvmName("TypedAsError")
fun <T> T.asError(): Error<T> = Error(this)

@JvmName("TypedAsOk")
fun <T> T.asOk(): Ok<T> = Ok(this)
