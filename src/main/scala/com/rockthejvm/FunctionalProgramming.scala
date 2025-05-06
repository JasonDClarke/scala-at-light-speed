package com.rockthejvm

object FunctionalProgramming extends App {

  // Scala is OO
  class Person(name: String) {
    def apply(age: Int): Unit = println(s"I have aged $age years")
  }
  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // INVOKING bob as a function === bob.apply(43)

  /*
    Scala runs on the JVM
    Functional programming:
    - compose functions
    - pass functions as args
    - return functions as results

    Conclusion: FunctionX = Function1, Function2, ... Function22
   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }

  simpleIncrementer.apply(23)
  simpleIncrementer(23) // simpleIncrementer.apply(23)
  // defined a function

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPE
  val stringConcatenator = new Function2[String, String, String] {
    override  def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  val doubler: Int => Int = (x: Int) => 2 * x
  doubler(4) // 8

  /*
    equivalent to the much longer:
    val doubler: Function1[Int, Int] = new Function1(Int, Int) {
      override def apply(x: Int) = 2 * x
    }
   */

  // higher-order functions: take functions as args/return functions as results
  val aMappedList: List[Int] = List(1,2,3).map(x => x+1)
  println(aMappedList)

  val aFlatMappedList = List(1,2,3).flatMap {
    x => List(x, 2 * x)
  } // alternative syntax
  println(aFlatMappedList)

  val aFilteredList = List(1,2,3,4,5).filter(_ <=3) // equivalent to x => x <=3
  println(aFilteredList)

  // all pairs between the numbers 1,2,3 and the letters 'a', 'b','c'
  val allPairs = List(1,2,3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))
  println(allPairs)


}
