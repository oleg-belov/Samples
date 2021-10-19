package com.obelov

import com.obelov.encapsulation.CompanionClassObjectEncapsulationExample
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CompanionClassObjectEncapsulationExampleTest {

  @Test def `should be equal class private field` (): Unit = {
    // arrange
    val expected = 0

    // act
    val actual = CompanionClassObjectEncapsulationExample.tmp

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should be equal object private field` (): Unit = {
    // arrange
    val expected = 1

    // act
    val actual = new CompanionClassObjectEncapsulationExample().tmp

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should be equal class private method` (): Unit = {
    // arrange
    val expected = 0

    // act
    val actual = CompanionClassObjectEncapsulationExample.method()

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should be equal object private method` (): Unit = {
    // arrange
    val expected = 1

    // act
    val actual = new CompanionClassObjectEncapsulationExample().method()

    // assert
    assertEquals(expected, actual)
  }
}
