package com.obelov.imports

// import single static method
import java.lang.Integer.valueOf

// import all static methods
import org.junit.jupiter.api.Assertions._

// import class
import org.junit.jupiter.api.Test

// import class from one package
import java.util.{HashMap, TreeMap}

// import the hole package
import java.math._

// import the hole package, rename one class
import java.io.{StringWriter => SW, _}

// import the hole package, except BeanInfo
import java.beans.{BeanInfo => _, _}

// import package - new serial.SerialArray
import javax.sql.rowset.serial

// rename function
import java.lang.Double.{isInfinite => isInf}

class ImportsTest {

  @Test def `should parse string to int`: Unit = {
    // arrange
    val expected = 42

    // act
    val actual = valueOf("42")

    // assert
    assertEquals(expected, actual)
  }

  @Test def `should call Double.isInfinite() as isInf()`: Unit = {
    // arrange

    // act
    val actual = isInf(Double.NegativeInfinity)

    // assert
    assertTrue(actual)
  }

  @Test def `should call Double.isNaN() as isNaN() - local import`: Unit = {
    // arrange
    import java.lang.Double.isNaN

    // act
    val actual = isNaN(Double.NaN)

    // assert
    assertTrue(actual)
  }
}
