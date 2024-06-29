package ru.code4a.errorhandling

interface ProcessError {
  val detailedMessage: String
    get() = qualifiedMessage

  val message: String

  val qualifiedMessage: String
    get() = "${this.message} (at ${this::class.qualifiedName})"

  fun messageWithCause(cause: ProcessError): String = "${this.qualifiedMessage}\n\tCause: ${cause.detailedMessage}\n"
}
