package com.rockthejvm

import scala.util.{Failure, Success, Try}

object Advanced extends App {
  /**
    * lazy evaluation
    */
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy")
    43
  }

  val eagerValue = lazyValueWithSideEffect +1

  // useful in infinite collections

  /**
   * "pseudo-collections": Option, Try
   */
  def methodWhichCanReturnNull(): String = "hello, Scala"
//  if (methodWhichCanReturnNull() == null) {
//    // defensive code against null
//  }
  val anOption = Option(methodWhichCanReturnNull()) // Some("hello, Scala")
  // option = "collection" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }

  // map, flatMap, filter

  def methodWhichCanThrowException(): String = throw new RuntimeException
//  try {
//    methodWhichCanThrowException()
//  } catch {
//    case e: Exception => "defend against this evil exception"
//  }
  val aTry = Try(methodWhichCanThrowException())
  // a try = "collection" with either a value if the code went well, or an exception if the code threw one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string: $validValue"
    case Failure(ex) => s"I have obtained an exception: $ex"
  }
  // map, flatMap, filter

  /**
   * Evaluate something on another thread
   * (asynchronous programming
   */


}
