package com.obelov.types.definition

/**
  *
  * A sealed trait can be extended only in the same file as its declaration.
  * They are often used to provide an alternative to enums. Since they can be only extended in a single file, the
  * compiler knows every possible subtypes and can reason about it.
  *
  */
sealed trait SelectedTraitExample
case object Yes extends SelectedTraitExample
case object No extends SelectedTraitExample
