package com.obelov.monads

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

/**
  *
  * must satisfy three important properties:
  *
  * Associativity: (x flatMap f) flatMap g == x flatMap (y => f(y) flatMap g)
  * Left unit: unit(x) flatMap f == f(x)
  * Right unit: m flatMap unit == m
  *
  */
class MonadsExampleTest {

}
