package com.obelov.generics

import com.obelov.generics.model._
import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

import scala.collection.mutable.ListBuffer

class GenericsExampleTest {

  @Test def `should map LinkedList correctly`: Unit =  {
    // arrange
    val initial = LinkedList(2, 3, 4)
    val expected = LinkedList(4, 9, 16)

    // act
    val actual = initial.map(x => x * x)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should sum LinkedList elems correctly`: Unit =  {
    // arrange
    val initial = LinkedList(2, 3, 4)
    val expected = 9

    // act
    val actual = LinkedList.sum(initial)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should join LinkedList elems correctly`: Unit =  {
    // arrange
    val initial: LinkedList[String] = LinkedList("Hello", " ", "scala", "!")
    val expected = "Hello scala!"

    // act
    val actual = LinkedList.join(initial)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should apply separator on join LinkedList elems`: Unit =  {
    // arrange
    val separator = ", "
    val initial: LinkedList[String] = LinkedList("Scala", "Java")
    val expected = "Scala, Java"

    // act
    val actual = LinkedList.join(initial, separator)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should foldLeft summing all numbers`: Unit =  {
    // arrange
    val initial = LinkedList(2, 3, 4)
    val expected = 9

    // act
    val actual = initial.foldLeft(0)((acc,item) => acc + item)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should map and foldLeft to sum the squares`: Unit =  {
    // arrange
    val initial = LinkedList(2, 3, 4)
    val expected = 29

    // act
    val actual = initial.map(x => x * x).foldLeft(0)((acc, x) => acc + x)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should foldLeft making a single string from all numbers`: Unit =  {
    // arrange
    val initial: LinkedList[String] = LinkedList("Hello", " ", "scala", "!")
    val expected = "Hello scala!"

    // act
    val actual = initial.foldLeft(new StringBuilder())((acc,item) => acc.append(item) ).toString()

    // assert
    assertEquals(expected, actual)
  }
  @Test def `should reverse a list`: Unit =  {
    // arrange
    val initial: LinkedList[String] = LinkedList("Hello", " ", "scala", "!")
    val expected = LinkedList("!", "scala", " ", "Hello")

    // act
    val actual = initial.reverse()

    // assert
    assertEquals(expected, actual)
  }
  @Test def `should filter a list`: Unit =  {
    // arrange
    val initial = LinkedList(2, 3, 4)
    val expected = LinkedList(2, 4)

    // act
    val actual = initial.filter(x => (x % 2) == 0)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should build lists with cons`: Unit =  {
    // arrange
    val expected = LinkedList(2, 4)

    // act
    val actual = 2 :: 4 :: Empty

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should build lists with cons manually`: Unit =  {
    // arrange
    val expected = LinkedList(2, 4)

    // act
    val actual =  Empty.::(4).::(2)

    // assert
    assertEquals(expected, actual)
  }
  @Test def `should appending two lists`: Unit =  {
    // arrange
    val items = new ListBuffer[Int]()
    val initial = LinkedList(1, 2, 3, 4)
    val expected = List(1, 2, 3, 4)

    // act
    initial.foreach( (x) => items += x )

    // assert
    assertEquals(expected, items)
  }
}
