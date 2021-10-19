package com.obelov.collections

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RangeSuite {

  @Test def `should return range of 4 elems - on Range: 1 until 5` (): Unit = {
    // arrange
    val range = 1 until 5 // 1, 2, 3, 4
    val expected = 4

    // act
    // assert
    assertEquals(expected, range.length)
  }

  @Test def `should return range of 5 elems - on Range: 1 to 5` (): Unit = {
    // arrange
    val range = 1 to 5 // 1, 2, 3, 4, 5
    val expected = 5

    // act
    // assert
    assertEquals(expected, range.length)
  }

  @Test def `should return range of elems - on Range: 1 to 5 with step 3` (): Unit = {
    // arrange
    val range = 1 to 5 by 3// 1, 4
    val expected = 2

    // act
    // assert
    assertEquals(expected, range.length)
  }
}
