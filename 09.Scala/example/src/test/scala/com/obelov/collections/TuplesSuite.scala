package com.obelov.collections

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TuplesSuite {

  @Test def `should return pair of elem - Tuple to value` (): Unit = {
    // arrange
    val pair = ("answer", 42)   // type: (String, Int)

    // act
    val (label, value) = pair

    // assert
    assertEquals("answer", label)
    assertEquals("answer", pair._1)
    assertEquals(42, value)
    assertEquals(42, pair._2)
  }
}
