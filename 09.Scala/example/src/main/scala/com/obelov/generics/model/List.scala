package com.obelov.generics.model

import scala.annotation.tailrec

/**
  *
  * + E - We accept objects of type E and it’s subclasses
  *
  * TRAIT because I don’t want people to be able to create LinkedList objects directly.
  *
  * By making it SELECTED we let the compiler know that only classes inside the same file as the declaration of
  * LinkedList can inherit/implement it
  *
  */
sealed trait LinkedList[+E] {

  def size: Int

  def foreach(f: (E) => Unit) {
    @tailrec def loop(items: LinkedList[E]) {
      items match {
        case Node(head, tail) => {
          f(head)
          loop(tail)
        }
        case Empty => {}
      }
    }

    loop(this)
  }

  /**
    *
    * [B >: E] is there to make the Empty case possible given when you do Empty.::(1) you are effectively building a
    * new list of Int out of a LinkedList[Nothing] and you need to say it’s valid to create a new list of type B
    * given B is a super type of E as E in this case is Nothing, the subtype of all types. So [B>: E] means that B is
    * any super type of E.
    *
    */
  def ::[B >: E](element: B): LinkedList[B] = Node(element, this)

  def :::[B >: E](prefix: LinkedList[B]): LinkedList[B] = {

    @tailrec def helper(acc: LinkedList[B], other: LinkedList[B]): LinkedList[B] = {
      other match {
        case Node(head, tail) => helper(head :: acc, tail)
        case Empty => acc
      }
    }

    helper(this, prefix.reverse())
  }

  /* /*
    sealed trait LinkedList[+E] {
      def map[R]( f : E => R ) : LinkedList[R]
    }

    case class Node[+E]( val head : E, val tail : LinkedList[E]  ) extends LinkedList[E] {
      override def map[R]( f : E => R ) : LinkedList[R] = Node(f(head), tail.map(f))
    }

    case object Empty extends LinkedList[Nothing] {
      override def map[R]( f : Nothing => R ) : LinkedList[R] = this
    }
    */
  def map[R](f: E => R): LinkedList[R] = {
    this match {
      case Node(head, tail) => Node(f(head), tail.map(f))
      case Empty => Empty
    }
  }*/
  def map[R](f: E => R): LinkedList[R] = foldRight(LinkedList[R]()) {
    (item, acc) =>
      Node(f(item), acc)
  }

  def reverse(): LinkedList[E] = {
    foldLeft(LinkedList[E]()) {
      (acc, item) =>
        Node(item, acc)
    }
  }

  def foldRight[B](accumulator: B)(f: (E, B) => B): B = {
    reverse().foldLeft(accumulator)((acc, item) => f(item, acc))
  }

  def filter(f: (E) => Boolean): LinkedList[E] = {
    foldRight(LinkedList[E]()) {
      (item, acc) =>
        if (f(item)) {
          Node(item, acc)
        } else {
          acc
        }
    }
  }

  @tailrec final def foldLeft[B](accumulator: B)(f: (B, E) => B): B = {
    this match {
      case Node(head, tail) => {
        val current = f(accumulator, head)
        tail.foldLeft(current)(f)
      }
      case Empty => accumulator
    }
  }

  @tailrec final def find(p: (E) => Boolean): Option[E] = {
    this match {
      case Node(head, tail) => {
        if (p(head)) {
          Some(head)
        } else {
          tail.find(p)
        }
      }
      case Empty => None
    }
  }
}

/**
  *
  *
  */
case class Node[+E](val head: E, val tail: LinkedList[E]) extends LinkedList[E] {
  val size = 1 + tail.size
}

/**
  *
  * Nothing, the subclass of everything
  *
  */
case object Empty extends LinkedList[Nothing] {
  val size = 0
}

object LinkedList {

  /**
    *
    * items : E*, which is a vararg (the * denotes it’s a sequence of Es) and we use it to recursively build the list.
    *
    * _* is required for us to tell the compiler we are not sending in a sequence of E as the first parameter but the
    * sequence is all the parameters
    *
    */
  def apply[E](items: E*): LinkedList[E] = {
    if (items.isEmpty) {
      Empty
    } else {
      Node(items.head, apply(items.tail: _*))
    }
  }

  def sum(numbers: LinkedList[Int]): Int = {
    numbers match {
      case Node(head, tail) => head + sum(tail)
      case Empty => 0
    }
  }

  def join(numbers: LinkedList[String], separator: String = ""): String = {
    numbers match {
      case Node(head, tail) => head + separator + join(tail)
      case Empty => ""
    }

  }
}
