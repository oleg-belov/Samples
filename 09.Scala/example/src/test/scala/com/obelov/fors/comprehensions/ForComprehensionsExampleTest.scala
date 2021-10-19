package com.obelov.fors.comprehensions

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

/**
  *
  * s is a sequence of generators and filters
  * p <- e is a generator
  * if f is a filter
  * If there are several generators (equivalent of a nested loop), the last generator varies faster than the first
  * You can use { s } instead of ( s ) if you want to use multiple lines without requiring semicolons
  * e is an element of the resulting collection
  *
  */
class ForComprehensionsExampleTest {

  @Test def `should generate list of tuples all combinations of numbers x and y = (1,1), (1,2),...(M,N)`: Unit = {
    // arrange
    val M = 10
    val N = 9
    val expected = (1 to M).flatMap(x => (1 to N).map(y => (x, y)))

    // act
    val actual = for (x <- 1 to M; y <- 1 to N) yield (x, y)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should list add postfix to all elems`: Unit = {
    // arrange
    val initialList = List("Cool", "tools", "rule")
    val expected = initialList.map(_ + "a")

    // act
    val actual = for (x <- initialList) yield x + "a"

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should filter list and add postfix to all elems`: Unit = {
    // arrange
    val N = 9
    val initialList = List("Cool", "tools", "rule")
    val expected = initialList.filter(_.contains('o')).flatMap(x => (1 to N) map (y => x + y))

    // act
    val actual = for {
      x <- initialList
      y <- 1 to N
      if (x.contains('o'))
    } yield x + y

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should iter based on previous`: Unit = {
    // arrange
    val N = 9
    val expected = (1 until N).flatMap(i => (1 until i).filter(j => isPrime(i + j)).map(j => (i, j)))

    // act
    val actual = for {
      i <- 1 until N
      j <- 1 until i
      if isPrime(i + j)
    } yield (i, j)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should iter based on previous filter with pattern matching`: Unit = {
    // arrange
    val N = 9
    val expected = (1 until N).filter(isPrime(_)).flatMap(i => (1 until i).map(j => (i, j)))

    // act
    val actual = for {
      i <- 1 until N withFilter {
        case path => isPrime(path)
        case _ => false
      } map {
        case path => path
      }
      j <- 1 until i
    } yield (i, j)

    // assert
    assertEquals(expected, actual)
  }

  private def isPrime(n: Int): Boolean = ! ((2 until n-1) exists (n % _ == 0))
}
