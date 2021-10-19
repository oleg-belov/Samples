package com.obelov.generics

import com.obelov.generics.model._

/**
  *
  * A <: B // means A is SUBTYPE of B                 // A covariant class
  * Q[A <: B] means that class Q can take any class A that is a subclass of B.
  *
  * +B // A covariant class
  *
  * Q[+B] means that Q can take any class, but if A is a subclass of B, then Q[A] is considered to be a subclass of Q[B].
  *
  * Q[+A <: B] means that class Q can only take subclasses of B as well as propagating the subclass relationship.
  *
  *
  * C >: B // means C is SUPERTYPE of B              // A contravariant class
  *
  * -B // A contravariant class
  *
  *
  * A >: B <: C // means A is any type on interval between B and C.
  *
  *
  * B // An invariant class
  *
  *
  * Example: Child <: GPars
  * List<Child> <: List<GPars>
  *
  */
object GenericsExample {

  GPars.typeAndSubTypes(new TypeAndSubTypes[Child]) // success

  GPars.typeAndSubTypes(new TypeAndSubTypes[Parent]) // success

  //  GPars.foo(new Box[GParent]) // type error


  //  GPars.foo0(new Box0[Child]) // type error

  GPars.typeAsSubtypeOf(new TypeAsSubtypeOf[Parent]) // success

  //  GPars.foo0(new Box0[GParent]) // type error

  GPars.typeAndSubTypesAsSubtypeOf(new TypeAndSubTypesAsSubtypeOf[Child]) // success

  GPars.typeAndSubTypesAsSubtypeOf(new TypeAndSubTypesAsSubtypeOf[Parent]) // success

  //    GPars.foo00(new Box00[GParent]) // type error


  //  GPars.bar(new Box2[Child]) // type error

  GPars.typeAndSupertypes(new TypeAndSupertypes[Parent]) // success

  GPars.typeAndSupertypes(new TypeAndSupertypes[GParent]) // success

  //  GPars.bar0(new Box20[Child]) // type error

  GPars.typeAsSuperType(new TypeAsSuperType[Parent]) // success

  //  GPars.bar0(new Box20[GParent]) // success


  //  GPars.baz(new Box3[Child]) // type error

  GPars.typeOnly(new TypeOnly[Parent]) // success

  //  GPars.baz(new Box3[GParent]) // type error


  //  GPars.qux(new Box4[Child]) // type error
  GPars.typeAsTypeBetween(new TypeAsTypeBetween[Parent]) // success
  //  GPars.qux(new Box4[GParent])  // type error


  GPars.typeAsTypeBetween(new TypeAndSubtypesAsTypeBetween[Child]) // success
  GPars.typeAsTypeBetween(new TypeAndSubtypesAsTypeBetween[Parent]) // success
  //  GPars.qux0(new Box5[GParent])  // type error
}
