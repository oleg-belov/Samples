package com.obelov.static.utils

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class UtilExampleTest {

  @Test def `should return java.lang.Integer.MAX_Value`: Unit = {
    // arrange

    // act

    // assert
    assertEquals(Integer.MAX_VALUE, UtilExample.MAX_INT)
  }

  @Test def `should return max Int value`: Unit = {
    // arrange
    val expected = Integer.MAX_VALUE

    // act
    val actual = UtilExample.max(expected, Integer.MIN_VALUE)

    // assert
    assertEquals(expected, actual)
  }
}
