package com.obelov.func

import com.obelov.func.FunctionExample.sum

import scala.annotation.tailrec

object FunctionExample {

  /**
    *
    * FunctionExample.method -> ok
    * FunctionExample.method() -> ok
    *
    */
  def method(): Int = 1

  /**
    *
    * FunctionExample.methodWithoutParentless -> ok
    * FunctionExample.methodWithoutParentless() -> compile error
    *
    */
  def methodWithoutParentless: Int = 1


  def increment(x: Int): Int = x + 1

  def incrementNestedFunc(x: Int): Int = {
    def increment(x: Int): Int = x + 1

    increment(x)
  }

  def fibonacciRecursion(x: Int): Int = if(x <= 1) x else fibonacciRecursion(x - 1) + fibonacciRecursion(x - 2)

  /**
    *
    * The tail recursive functions better than non tail recursive functions because tail-recursion
    * can be optimized by compiler. A recursive function is said to be tail recursive if the recursive call
    * is the last thing done by the function. There is no need to keep record of the previous state.
    *
    * We can use the @tailrec annotation to confirm that our algorithm is tail recursive.
    * If we use this annotation and our algorithm isn’t tail recursive, the compiler will complain.
    *
    */
  def factorial(x: Int): Int = {
    @tailrec
    def factorialAcc(acc: Int, n: Int): Int = {
      if (n <= 1)
        acc
      else
        factorialAcc(n * acc, n - 1)
    }

    factorialAcc(1, x)
  }

  /**
    *
    * Higher-Order Functions
    *
    */
  private def sum(f: Int => Int, a: Int, b:Int): Int = {
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)
  }

  def id(x: Int): Int = x

  def sumInts(a: Int, b: Int): Int = sum(id, a, b)

  def sumCubes(a: Int, b: Int): Int = sum(x => x * x * x, a, b)

  /**
    *
    * Function returning function
    *
    * def sum(f: Int => Int): (Int, Int) => Int =
    *   if (a > b) 0 else f(a) + sum(f)(a + 1, b)
    */
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b:Int): Int = {
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    }

    sumF
  }

  /**
    *
    * Varying as function parameter
    *
    */
  def createList[T](elems: T* ) = elems.toList
}
