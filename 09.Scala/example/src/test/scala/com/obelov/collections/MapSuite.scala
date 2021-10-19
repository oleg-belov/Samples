package com.obelov.collections

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MapSuite {

  /**
    *  (Map.get) return a value of type Option[T] which is either a value of type Some[T] or the value None
  * */
  @Test def `should return default value if not found in map, Pattern Matching` (): Unit = {
    // arrange
    val myMap = Map("a" -> 42, "b" -> 43)

    def getMapValue(s: String): String = {
      myMap.get(s) match {
        case Some(nb) => nb.toString
        case None => "No value found"
      }
    }

    // act

    // assert
    assertEquals("42", getMapValue("a"))
    assertEquals("No value found", getMapValue("c"))
  }

  @Test def `should return default value if not found in map, Option` (): Unit = {
    // arrange
    val myMap = Map("a" -> 42, "b" -> 43)

    def getMapValue(s: String): String = myMap.get(s).map(_.toString).getOrElse("No value found")

    // act

    // assert
    assertEquals("42", getMapValue("a"))
    assertEquals("No value found", getMapValue("c"))
  }
}
