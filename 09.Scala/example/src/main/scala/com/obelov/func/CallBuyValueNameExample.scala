package com.obelov.func

/**
  *
  * test(2, 3) -> buy value -> 2 * 2 => 4                                       // same
  *   -> buy name -> 2 * 2 => 4
  *
  * test(3 + 4, 8) -> buy value -> test(7, 8) -> 7 * 7 => 49                    // buy value optimal
  *   -> buy name -> (3+4) * (3+4) -> 7 * (3+4) -> 7 * 7 => 49
  *
  * test(7, 2*4) -> buy value -> test(7, 8) ->  7 * 7 => 49                     // buy name optimal
  *   -> buy name -> 7 * 7 => 49
  *
  * test(3 + 4, 2*4) -> buy value -> test(7, 2*4) -> test(7, 8) -> 7 * 7 => 49  // same
  *   -> buy name -> (3+4) * (3+4) -> 7 * (3+4) -> 7 * 7 => 49
  *
  */
object CallBuyValueNameExample {
  def test(x: Int, y: Int): Int = x * x

  /**
    *
    * Scala normally use call buy value
    * But if the type a function parameter starts with => it uses call buy name
    *
    */
  def constOne(x: Int, y: => Int): Int = 1
}
