package com.rockthejvm

object ObjectOrientation extends App{
  class Animal {
    // define fields
    val age: Int = 0

    // define methods
    def eat(): Unit = println("I'm eating")
  }

  // class and instance
  val anAnimal = new Animal

  // inheritance
  // constructor definition
  class Dog(val name: String) extends Animal

  val aDog = new Dog("Lassie")

  // constructor arguments are NOT fields: need to put a val before the constructor argument
  aDog.name

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // by default public, can restrict by adding protected or private
    def walk(): Unit
  }

  // "interface" = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }

  // single-class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = println("I am eating you, animal!")

    def ?!(thought: String): Unit = println(s"I was thinking: $thought")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument, only available for methods with ONE argument
  aCroc ?! "What if we could fly?"

  // operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty much anything")
  }

  /*
    this is what you tell the compiler
    class Carnivore_Anonymous_35728 extends Carnivore {
      override def eat(animal: Animal): Unit = println("I am a dinosaur so I can eat pretty much anything")
    }
    val dinosaur = new Carnivore_Anonymous_35728
   */

  // singleton object
  object mySingleton {
    val mySpecialValue = 53278
    def mySpecialMethod(): Int = 5327
    def apply(x: Int): Int = x + 1
  }// the only instance of the mySingleton type

  MySingleton.mySpecialMethod()
  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton.apply(65)


}

