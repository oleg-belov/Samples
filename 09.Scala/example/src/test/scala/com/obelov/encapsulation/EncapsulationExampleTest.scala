package com.obelov.encapsulation

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class EncapsulationExampleTest {

  @Test def `should increment value on static class` (): Unit = {
    // arrange
    val expected = 2

    // act
    val actual = com.obelov.encapsulation.subpackage.EncapsulationExample.increment(1)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should increment value on class` (): Unit = {
    // arrange
    val expected = 2

    // act
    val actual = new EncapsulationExample().increment(1)

    // assert
    assertEquals(expected, actual)
  }
}
