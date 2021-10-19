package com.obelov.types.definition

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class PreconditionValidationExampleTest {

  @Test def `should create object`: Unit = {
    // arrange
    val expectedX = 3
    val expectedY = 6

    // act
    val actual = PreconditionValidationExample(expectedX, expectedY)

    // assert
    assertEquals(expectedX, actual.x)
    assertEquals(expectedY, actual.y)
  }

  @Test def `should throws exception`: Unit = {
    // arrange
    val expectedMessage = "requirement failed: y must be positive"
    val expectedX = 3
    val expectedY = 0

    // act
    val exception = assertThrows(classOf[IllegalArgumentException], () => PreconditionValidationExample(expectedX, expectedY))

    // assert
    assertEquals(expectedMessage, exception.getMessage)
  }
}
