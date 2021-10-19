package com.obelov.accessor.mutators

import scala.beans.BeanProperty

class AccessorMutatorExample {
  val firstName: String = null
  var lastName: String = _

  private[this] var age: Int = _

  @BeanProperty var sex: String = _

  def getAge() = this.age

  def setAge(age: Int): Unit = this.age = age
}
