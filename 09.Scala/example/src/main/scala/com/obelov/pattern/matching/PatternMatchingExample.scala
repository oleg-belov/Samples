package com.obelov.pattern.matching

class PatternMatchingExample {

  def getArrayDef[T](someList: List[T]): String = someList match {
    case Nil => "null"          // empty list
    case x :: Nil => x.toString    // list with only one element
    case List(x) => x.toString     // same as above
    case 1 :: 2 :: cs => "1" // lists that starts with 1 and then 2
    case (x, y) :: ps => "x" // a list where the head element is a pair
    case x :: xs => x.toString      // a list with at least one element. x is bound to the head,
    // xs to the tail. xs could be Nil or some other list.
    case _ => "Nothing"            // default case if none of the above matches
  }
}
