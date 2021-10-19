package com.obelov.collections

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.{BeforeEach, Test}

class ListsSuite {

  var initialList: List[String] = Nil
  var list: List[String] = Nil

  @BeforeEach def init(): Unit = {
    initialList = List("Cool", "tools", "rule")
    list = "Cool":: "tools" :: "rule" :: Nil
  }

  /*
  xs updated(n, x)  // same list than xs, except at index n where it contains x, complexity O(n)
xs indexOf x      // the index of the first element equal to x (-1 otherwise)
xs contains x     // same as xs indexOf x >= 0
xs filter p       // returns a list of the elements that satisfy the predicate p
xs filterNot p    // filter with negated p
xs partition p    // same as (xs filter p, xs filterNot p)
xs takeWhile p    // the longest prefix consisting of elements that satisfy p
xs dropWhile p    // the remainder of the list after any leading element satisfying p have been removed
xs span p         // same as (xs takeWhile p, xs dropWhile p)

List(x1, ..., xn) reduceLeft op    // (...(x1 op x2) op x3) op ...) op xn
List(x1, ..., xn).foldLeft(z)(op)  // (...( z op x1) op x2) op ...) op xn
List(x1, ..., xn) reduceRight op   // x1 op (... (x{n-1} op xn) ...)
List(x1, ..., xn).foldRight(z)(op) // x1 op (... (    xn op  z) ...)

xs exists p    // true if there is at least one element for which predicate p is true
xs forall p    // true if p(x) is true for all elements
xs zip ys      // returns a list of pairs which groups elements with same index together
xs unzip       // opposite of zip: returns a pair of two lists
xs.flatMap f   // applies the function to all elements and concatenates the result
xs.sum         // sum of elements of the numeric collection
xs.product     // product of elements of the numeric collection
xs.max         // maximum of collection
xs.min         // minimum of collection
xs.flatten     // flattens a collection of collection into a single-level collection
xs groupBy f   // returns a map which points to a list of elements
xs distinct    // sequence of distinct entries (removes duplicates)

x +: xs  // creates a new collection with leading element x
xs :+ x  // creates a new collection with trailing element x
   */
  @Test def `should return concatenated list and not mutate lists - on List ::: List`(): Unit = {
    // arrange
    val secondList = List("Scala", "Java")

    val expected = List("Cool", "tools", "rule", "Scala", "Java")

    // act
    val actual = list ::: secondList

    // assert
    assertEquals(initialList, list)
    assertEquals(List("Scala", "Java"), secondList)

    assertEquals(expected, actual)
  }

  @Test def `should prepend a new element to the head of an existing list - on elem :: List`(): Unit = {
    // arrange
    val expected = List("Java", "Cool", "tools", "rule")

    // act
    val actual = "Java" :: list

    // assert
    assertEquals(initialList, list)

    assertEquals(expected, actual)
  }

  @Test def `should create empty list`(): Unit = {
    // arrange
    val listOne = List()
    val listTwo = Nil

    // act
    // assert
    assertTrue(listOne.isEmpty)
    assertTrue(listTwo.isEmpty)
  }

  @Test def `should count elements by filter - on List.count(Predicate)`(): Unit = {
    // arrange
    val expected = 2

    // act
    val actual = list.count(s => s.length == 4)

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should affirm that at least one elem match - on List.exists`(): Unit = {
    // arrange
    // act
    val actual = list.exists(s => s.endsWith("l"))

    // assert
    assertTrue(actual)
  }

  @Test def `should affirm that all elems match - on List.forall`(): Unit = {
    // arrange
    // act
    val actual = list.forall(s => s.endsWith("l"))

    // assert
    assertFalse(actual)
  }

  @Test def `should return subList without first n elems - on List.drop`(): Unit = {
    // arrange
    val expected = List("rule")

    // act
    val actual = list.drop(2)

    // assert
    assertEquals(initialList, list)
    assertEquals(expected, actual)
  }

  @Test def `should return subList without last n elems - on List.dropRight`(): Unit = {
    // arrange
    val expected = List("Cool", "tools")

    // act
    val actual = list.dropRight(1)

    // assert
    assertEquals(initialList, list)
    assertEquals(expected, actual)
  }

  @Test def `should return subList of first n elems - on List.take`(): Unit = {
    // arrange
    val expected = List("Cool", "tools")

    // act
    val actual = list.take(2)

    // assert
    assertEquals(initialList, list)
    assertEquals(expected, actual)
  }

  @Test def `should return first element of the list - on List.head`(): Unit = {
    // arrange
    val expected = "Cool"

    // act
    val actual = list.head

    // assert
    assertEquals(initialList, list)
    assertEquals(expected, actual)
  }

  @Test def `should return sublist without first element - on List.tail`(): Unit = {
    // arrange
    val expected = List("tools", "rule")

    // act
    val actual = list.tail

    // assert
    assertEquals(initialList, list)
    assertEquals(expected, actual)
  }

  @Test def `should return sublist without last element - on List.init`(): Unit = {
    // arrange
    val expected = List("Cool", "tools")

    // act
    val actual = list.init

    // assert
    assertEquals(initialList, list)
    assertEquals(expected, actual)
  }

  @Test def `should return modified list - on List.map`(): Unit = {
    // arrange
    val expected = List("Cools", "toolss", "rules")

    // act
    val actual = list.map(s => s + "s")

    // assert
    assertEquals(initialList, list)
    assertEquals(expected, actual)
  }

  @Test def `should return modified list of pairs - on List.map`(): Unit = {
    // arrange
    val initialList: List[(String, Int)] = ("Cools", 2) :: ("rules", 3) :: Nil
    val expected = List("Cools", "rules")

    // act
    val actual = initialList.map{ case (str, num) => str }

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should join list by sep - on List.mkString`(): Unit = {
    // arrange
    val expected = "Cool, tools, rule"

    // act
    val actual = list.mkString(", ")

    // assert
    assertEquals(initialList, list)
    assertEquals(expected, actual)
  }

  @Test def `should return reversed list - on List.reverse`(): Unit = {
    // arrange
    val expected = List("rule", "tools", "Cool")

    // act
    val actual = list.reverse

    // assert
    assertEquals(initialList, list)
    assertEquals(expected, actual)
  }


  @Test def `should return sorted list - on List.sortWith`(): Unit = {
    // arrange
    val expected = List("Cool", "rule", "tools")

    // act
    val actual = list.sortWith((s, t) =>
      s.charAt(0).toLower <
        t.charAt(0).toLower)

    // assert
    assertEquals(initialList, list)
    assertEquals(expected, actual)
  }

  @Test def `should return elems sum - on List.sum`(): Unit = {
    // arrange
    val list = List(1, 2, 0)

    val expected = 3

    // act
    val actual = list.sum

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should return elem with have maximum value - on List.max`(): Unit = {
    // arrange
    val list = List(1, 2, 0)

    val expected = 2

    // act
    val actual = list.max

    // assert
    assertEquals(expected, actual)
  }
}
