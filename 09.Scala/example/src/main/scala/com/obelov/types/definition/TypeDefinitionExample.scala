package com.obelov.types.definition

trait T

class C

object O

object OT extends T

object OC extends C

object TypeDefinitionExample {

  val x: T = null
  val y: C = null
  //  val z: O = null // not allowed
  val z: O.type = null

  def f(x: T): T = ???

  def g(x: C): C = ???

  //  def h(x: O): O = ??? // not allowed
  def h(x: O.type): O.type = ???

  def k(arg: T): T = ???

  k(new T {})
  k(OT)

  def m(arg: C): C = ???

  m(new C)
  m(OC)

  def r(arg: Any): String = arg match {
    case _: x.type => "OT"
    case OT => "OT"

    case _: OC.type => "OC"
    //    case OC => "OC" // same

    case _: O.type => "O"
    //    case O => "O" // same

    case _: C => "C"
    case _: T => "T"
  }
}
