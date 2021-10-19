package com.obelov.types.definition

case class PreconditionValidationExample(x: Int, y: Int) {

  require(y > 0, "y must be positive")
}

object PreconditionValidationExample {
  val Y_VALIDATION_MESSAGE = "y must be positive"
}
