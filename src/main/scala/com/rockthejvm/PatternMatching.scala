package com.rockthejvm

object PatternMatching extends App {
  // switch expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }
  // PM is an EXPRESSION
  println(order)

  case class Person(name: String, age: Int)

  // Case class decomposition
  val bob = Person("Bob", 43) // Person.apply("bob")

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old."
    case _ => "Something else"
  }
  println(personGreeting)

  // deconstructing tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre"
    case _ => "I don't know what you're talking about"
  }

  // decomposing lists
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_,2,_) => "List containing 2 on its second position"
    case _ => "unknown list"
  }

  // if PM doesn't match anything, it will throw a MatchError
  // PM will try all cases in sequence
}
