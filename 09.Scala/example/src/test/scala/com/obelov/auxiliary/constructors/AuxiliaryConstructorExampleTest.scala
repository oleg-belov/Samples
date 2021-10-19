package com.obelov.auxiliary.constructors

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test

class AuxiliaryConstructorExampleTest {

  @Test def `should set default values on no args constructor` (): Unit = {
    // arrange

    // act
    val actual = new AuxiliaryConstructorExample()

    // assert
    assertEquals(AuxiliaryConstructorExample.DEFAULT_FIRST_NAME, actual.firstName)
    assertEquals(AuxiliaryConstructorExample.DEFAULT_LAST_NAME, actual.lastName)
    assertEquals(AuxiliaryConstructorExample.DEFAULT_SEX, actual.sex)
    assertEquals(AuxiliaryConstructorExample.DEFAULT_AGE, actual.age)
  }

  @Test def `should set first and last name on partial constructor` (): Unit = {
    // arrange
    val expectedFirstName = "Oleg"
    val expectedLastName = "Belov"

    // act
    val actual = new AuxiliaryConstructorExample(expectedFirstName, expectedLastName)

    // assert
    assertEquals(expectedFirstName, actual.firstName)
    assertEquals(expectedLastName, actual.lastName)
    assertEquals(AuxiliaryConstructorExample.DEFAULT_SEX, actual.sex)
    assertEquals(AuxiliaryConstructorExample.DEFAULT_AGE, actual.age)
  }

  @Test def `should set first, last, sex and age on all args constructor` (): Unit = {
    // arrange
    val expectedFirstName = "Oleg"
    val expectedLastName = "Belov"
    val expectedSex = "F"
    val expectedAge = 27

    // act
    val actual = new AuxiliaryConstructorExample(expectedFirstName, expectedLastName, expectedSex, expectedAge)

    // assert
    assertEquals(expectedFirstName, actual.firstName)
    assertEquals(expectedLastName, actual.lastName)
    assertEquals(expectedSex, actual.sex)
    assertEquals(expectedAge, actual.age)
  }

  @Test def `should set first, last name and sex on all args constructor` (): Unit = {
    // arrange
    val expectedFirstName = "Oleg"
    val expectedLastName = "Belov"
    val expectedSex = "F"

    // act
    val actual = new AuxiliaryConstructorExample(
      firstName = expectedFirstName, lastName = expectedLastName, sex = expectedSex)

    // assert
    assertEquals(expectedFirstName, actual.firstName)
    assertEquals(expectedLastName, actual.lastName)
    assertEquals(expectedSex, actual.sex)
    assertEquals(AuxiliaryConstructorExample.DEFAULT_AGE, actual.age)
  }
}

