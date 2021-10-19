package com.obelov.func

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class FunctionExampleTest {

  @Test def `should increment value on call increment function`: Unit = {
    // arrange
    val initial = 1
    val expected = 2

    // act
    val actual = FunctionExample.increment(initial)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should increment value on call incrementNestedFunc function`: Unit = {
    // arrange
    val initial = 1
    val expected = 2

    // act
    val actual = FunctionExample.incrementNestedFunc(initial)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should return fibonacci number`: Unit = {
    // arrange
    val input = 9
    val expected = 34

    // act
    val actual = FunctionExample.fibonacciRecursion(input)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should return factorial`: Unit = {
    // arrange
    val input = 9
    val expected = 362880

    // act
    val actual = FunctionExample.factorial(input)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should return sumInts`: Unit = {
    // arrange
    val inputA = 3
    val inputB = 9
    val expected = 42

    // act
    val actual = FunctionExample.sumInts(inputA, inputB)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should return sumCubes`: Unit = {
    // arrange
    val inputA = 3
    val inputB = 9
    val expected = 2016

    // act
    val actual = FunctionExample.sumCubes(inputA, inputB)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should return sum of ints`: Unit = {
    // arrange
    val inputA = 3
    val inputB = 9
    val expected = 42

    // act
    val actual = FunctionExample.sum(FunctionExample.id)(inputA, inputB)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should create List of ints`: Unit = {
    // arrange
    val inputA = 3
    val inputB = 9
    val expected = List(3, 9)

    // act
    val actual = FunctionExample.createList(inputA, inputB)

    // assert
    assertEquals(expected, actual)
  }
}
