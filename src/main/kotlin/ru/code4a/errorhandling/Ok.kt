package ru.code4a.errorhandling

class Ok<out OkType>(
  val value: OkType
) : OkOrError<OkType, Nothing>() {
  override val isError: Boolean
    get() = false
  override val isOk: Boolean
    get() = true

  override fun getOkElseThrow(): OkType = value
}
