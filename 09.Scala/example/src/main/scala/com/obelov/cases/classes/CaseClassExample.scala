package com.obelov.cases.classes

/**
  *
  * auto generate accessors/ mutators
  * Make every class parameter as a field
  * Is immutable by default
  * Perform value base equivalence by default
  *
  */
case class CaseClassExample(
                             hour: Int = CaseClassExample.DEFAULT_HOUR,
                             minutes: Int = CaseClassExample.DEFAULT_MINUTES
                           )

private object CaseClassExample {
  private val DEFAULT_HOUR = 0
  private val DEFAULT_MINUTES = 0
}