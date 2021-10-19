package com.obelov.encapsulation

// companion class
class CompanionClassObjectEncapsulationExample {
  private val classPrivate = 0
  private[this] val classPrivateThis = 0

  val tmp: Int = CompanionClassObjectEncapsulationExample.objectPrivate
//  val secondTemp = CompanionClassObjectEncapsulationExample.objectPrivateThis // can not access

  private def classPrivateMethod(): Int = 0

  private[this] def classPrivateThisMethod(): Int = 0

  def method(): Int = CompanionClassObjectEncapsulationExample.objectPrivateMethod()

//  def secondMethod(): Int = CompanionClassObjectEncapsulationExample.objectPrivateThisMethod() // can not access
}

// companion object
object CompanionClassObjectEncapsulationExample {
  private val objectPrivate = 1
  private[this] val objectPrivateThis = 1

  val tmp: Int = new CompanionClassObjectEncapsulationExample().classPrivate
//  val secondTemp = new CompanionClassObjectEncapsulationExample().classPrivateThis // can not access

  private def objectPrivateMethod(): Int = 1

  private[this] def objectPrivateThisMethod(): Int = 1

  def method(): Int = new CompanionClassObjectEncapsulationExample().classPrivateMethod()

//  def secondMethod(): Int = new CompanionClassObjectEncapsulationExample().classPrivateThisMethod() // can not access
}
