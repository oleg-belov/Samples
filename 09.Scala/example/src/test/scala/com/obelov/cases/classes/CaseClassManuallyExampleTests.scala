package com.obelov.cases.classes

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class CaseClassManuallyExampleTests {

  @Test def `should create class with default parameters`: Unit = {
    // arrange
    val expectedHour = 0
    val expectedMinutes = 0

    // act
    val actualUsingConstructor = new CaseClassManuallyExample()

    val actualUsingFactoryMethod = CaseClassManuallyExample()
//    val actualUsingFactoryMethod = CaseClassManuallyExample.apply() // same as above

    assertEquals(expectedHour, actualUsingConstructor.hour)
    assertEquals(expectedMinutes, actualUsingConstructor.minutes)

    assertEquals(expectedHour, actualUsingFactoryMethod.hour)
    assertEquals(expectedMinutes, actualUsingFactoryMethod.minutes)
  }

  @Test def `should create class with hour`: Unit = {
    // arrange
    val expectedHour = 10
    val expectedMinutes = 0

    // act
    val actualUsingConstructor = new CaseClassManuallyExample(expectedHour)

    val actualUsingFactoryMethod = CaseClassManuallyExample(expectedHour)

    assertEquals(expectedHour, actualUsingConstructor.hour)
    assertEquals(expectedMinutes, actualUsingConstructor.minutes)

    assertEquals(expectedHour, actualUsingFactoryMethod.hour)
    assertEquals(expectedMinutes, actualUsingFactoryMethod.minutes)
  }

  @Test def `should create class with minutes`: Unit = {
    // arrange
    val expectedHour = 0
    val expectedMinutes = 5

    // act
    val actualUsingConstructor = new CaseClassManuallyExample(minutes = expectedMinutes)

    val actualUsingFactoryMethod = CaseClassManuallyExample(minutes = expectedMinutes)

    assertEquals(expectedHour, actualUsingConstructor.hour)
    assertEquals(expectedMinutes, actualUsingConstructor.minutes)

    assertEquals(expectedHour, actualUsingFactoryMethod.hour)
    assertEquals(expectedMinutes, actualUsingFactoryMethod.minutes)
  }

  @Test def `should create class with hour and minutes`: Unit = {
    // arrange
    val expectedHour = 10
    val expectedMinutes = 5

    // act
    val actualUsingConstructor = new CaseClassManuallyExample(expectedHour, expectedMinutes)

    val actualUsingFactoryMethod = CaseClassManuallyExample(expectedHour, expectedMinutes)

    assertEquals(expectedHour, actualUsingConstructor.hour)
    assertEquals(expectedMinutes, actualUsingConstructor.minutes)

    assertEquals(expectedHour, actualUsingFactoryMethod.hour)
    assertEquals(expectedMinutes, actualUsingFactoryMethod.minutes)
  }

  @Test def `should create property base equals method`: Unit = {
    // arrange
    val expected = CaseClassManuallyExample(9, 0)

    // act
    val actual = CaseClassManuallyExample(9)

    assertEquals(expected, actual)
    assertTrue(expected == actual)
  }

  @Test def `should create copy method`: Unit = {
    // arrange
    val expected = CaseClassManuallyExample(9, 5)

    // act
    val actual = CaseClassManuallyExample(9).copy(minutes = 5)

    assertEquals(expected, actual)
    assertTrue(expected == actual)
  }

  @Test def `should override toString method`: Unit = {
    // arrange
    val expected = "CaseClassManuallyExample(9,0)"

    // act
    val actual = CaseClassManuallyExample(9).toString

    assertEquals(expected, actual)
  }
}
