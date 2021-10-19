package com.obelov.auxiliary.constructors

// auxiliary constructors
class   AuxiliaryConstructorExample(
                                   val firstName: String,
                                   val lastName: String,
                                   val sex: String = AuxiliaryConstructorExample.DEFAULT_SEX,
                                   val age: Int = AuxiliaryConstructorExample.DEFAULT_AGE
                                 ) {
  def this(firstName: String, lastName: String) {
    this(firstName, lastName, AuxiliaryConstructorExample.DEFAULT_SEX, AuxiliaryConstructorExample.DEFAULT_AGE)
  }

  def this() {
    this(AuxiliaryConstructorExample.DEFAULT_FIRST_NAME, AuxiliaryConstructorExample.DEFAULT_LAST_NAME)
  }
}

// companion object - as constant holder
object AuxiliaryConstructorExample {
  val DEFAULT_FIRST_NAME = ""
  val DEFAULT_LAST_NAME = ""
  val DEFAULT_SEX = "M"
  val DEFAULT_AGE = 26
}
