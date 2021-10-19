package com.obelov.accessor.mutators

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class AccessorMutatorExampleTest {

  @Test def `should generate accessors` (): Unit = {
    // arrange
    val expectedAge = 0

    // act
    val actual = new AccessorMutatorExample()

    // assert
    assertNull(actual.firstName)
    assertNull(actual.lastName)
    assertEquals(expectedAge, actual.getAge())
    assertNull(actual.getSex())
  }

  @Test def `should generate mutator` (): Unit = {
    // arrange
    val expectedAge = 26
    val expectedLastName= "Belov"
    val female = "F"
    val male = "M"

    // act
    val actual = new AccessorMutatorExample()

    actual.lastName = expectedLastName
    actual.setAge(expectedAge)
    actual.sex = female

    assertEquals(female, actual.getSex())

    actual.setSex(male)

    // assert
    assertEquals(expectedLastName, actual.lastName)
    assertEquals(expectedAge, actual.getAge())
    assertEquals(male, actual.getSex())
  }
}
