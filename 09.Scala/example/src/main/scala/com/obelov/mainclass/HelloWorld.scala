package com.obelov.mainclass

/**
  *
  * Implicit imports:
  *   import java.lang._
  *   import scala._
  *   import scala.Predef._
  *
  * Default encapsulation level => Java public
  * Default method modifier => Java static
  * Can not create instance => new Example -> compile time error
  *
  * class => Like Java CLASS without static members
  * trait => Like Java INTERFACE + ABSTRACT CLASS
  * object => LIKE Java CLASS only with static members + SINGLETON
  *
  */
/*public*/ object HelloWorld /* extends AnyRef */ {

//  var age: Int // not defaults! => abstract field
//  var age: Int = _ // Scala defaults
//  var age: Int = 1 // field initial value
  var age = 1 // type inference // not recommended for public api

  /*public*/ def main(/*final*/ args: Array[String]) {
    println("Hello, World!")
  }
}
