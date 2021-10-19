package com.obelov.collections

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class ArraySuite {

  @Test def `should return concatenated array - on array_1 ++ array_2` (): Unit = {
    // arrange
    val expected = Array(1, 2, 3, 4, 5, 6)

    val array_1 = Array(1, 2, 3)
    val array_2 = Array(4, 5, 6)

    // act
    val actual = array_1 ++ array_2

    // assert
    assertArrayEquals(expected, actual)
  }

  @Test def `should create fixed size array` (): Unit = {
    // arrange
    val expected = Array(1, 2, 3)

    // act
    val array = new Array[Int](3)

    array(0) = 1
    array(1) = 2
    array(2) = 3

    // assert
    assertArrayEquals(expected, array)
  }

  @Test def `should throw exception - on try to access elem out of array size` (): Unit = {
    // arrange

    // act
    val array = new Array[Int](3)

    // assert
    assertThrows(classOf[ArrayIndexOutOfBoundsException], () => array(3) = 3)
  }
}
