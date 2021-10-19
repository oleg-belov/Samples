package com.obelov.generics.model

class GParent

class Parent extends GParent

class Child extends Parent

/**
  * Parent:
  *
  * Child
  * Parent
  */
class TypeAndSubTypes[+A]

/**
  * Parent:
  *
  * Parent
  */
class TypeAsSubtypeOf[A <: Parent]

/**
  * Parent:
  *
  * Child
  * Parent
  */
class TypeAndSubTypesAsSubtypeOf[+A <: Parent]

/**
  * Parent:
  *
  * Parent
  * GParent
  */
class TypeAndSupertypes[-A]

/**
  * Parent:
  *
  * Parent
  */
class TypeAsSuperType[A >: Parent]

/**
  * Parent:
  *
  * Parent
  */
class TypeOnly[A]

/**
  * Parent:
  *
  * Parent
  */
class TypeAsTypeBetween[A >: Child <: GParent]

/**
  * Parent:
  *
  * Child
  * Parent
  */
class TypeAndSubtypesAsTypeBetween[+A >: Child <: GParent]

object GPars {

  def typeAndSubTypes(x: TypeAndSubTypes[Parent]): TypeAndSubTypes[Parent] = identity(x)

  def typeAsSubtypeOf(x: TypeAsSubtypeOf[Parent]): TypeAsSubtypeOf[Parent] = identity(x)

  def typeAndSubTypesAsSubtypeOf(x: TypeAndSubTypesAsSubtypeOf[Parent]): TypeAndSubTypesAsSubtypeOf[Parent] = identity(x)

  def typeAndSupertypes(x: TypeAndSupertypes[Parent]): TypeAndSupertypes[Parent] = identity(x)

  def typeAsSuperType(x: TypeAsSuperType[Parent]): TypeAsSuperType[Parent] = identity(x)

  def typeOnly(x: TypeOnly[Parent]): TypeOnly[Parent] = identity(x)

  def typeAsTypeBetween(x: TypeAsTypeBetween[Parent]): TypeAsTypeBetween[Parent] = identity(x)

  def typeAsTypeBetween(x: TypeAndSubtypesAsTypeBetween[Parent]): TypeAndSubtypesAsTypeBetween[Parent] = identity(x)
}
