package com.obelov.collections

import org.junit.jupiter.api.Assertions.{assertEquals, assertNotEquals}
import org.junit.jupiter.api.{Assertions, BeforeEach, Test}

class SetsSuite {

  var initialSet: Set[String] = Set()
  var set: Set[String] = Set()
  var mutableSet: scala.collection.mutable.Set[String] = scala.collection.mutable.Set()

  @BeforeEach def init(): Unit = {
    initialSet = Set("Cool", "tools", "rule")
    set = Set("Cool", "tools", "rule")
    mutableSet = scala.collection.mutable.Set("Cool", "tools", "rule")
  }

  @Test def `should add element to set` (): Unit = {
    // arrange
   val initial = Set("Cool", "tools", "rule")
   val expected = Set("Cool", "tools", "rule", "scala")

    // act
    val actual =  initialSet + "scala"
    set += "scala"

    // assert
    assertEquals(initial, initialSet)
    assertEquals(expected, actual)
    assertEquals(expected, set)
  }

  @Test def `should not add existing element to set` (): Unit = {
    // arrange
    val expected = Set("Cool", "tools", "rule")

    // act
    val actual =  initialSet + "Cool"
    set += "Cool"

    // assert
    assertEquals(expected, initialSet)
    assertEquals(expected, actual)
    assertEquals(expected, set)
  }

  @Test def `should add element to mutable set` (): Unit = {
    // arrange
    val expected = Set("Cool", "tools", "rule")

    // act
    val actual =  mutableSet + "Cool"
    set += "Cool"

    // assert
    assertEquals(expected, mutableSet)
    assertEquals(expected, actual)
    assertEquals(expected, set)
  }
}
