object ContextualAbstractions {
  /*
    1 - context parameters/arguments
   */
  val aList = List(2,1,3,4)
  val anOrderedList = aList.sorted // contextual argument: (orderingDescending)

  // Ordering
  // (a,b) => a > b
  given descendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _)

  // analogous to an implicit val

  trait Combinator[A] {
    def combine(x: A, y: A): A
  }

  def combineAll[A](list: List[A])(using combinator: Combinator[A]): A =
    list.reduce(combinator.combine) // (a,b) => combinator.combine(a,b)

  given intCombinator: Combinator[Int] = new Combinator[Int] {
    override def combine(x: Int, y: Int): Int = x + y
  }
  val theSum = combineAll(aList) // (intCombinator)

  /* Given places
    - local scope
    - imported scope
    - the companions of all the types involved in the call
    - eg the companion of List, and the companion of Int
   */
  // combineAll(List(,2,3,4)

  // context bounds
  def combineAll_v2[A](list: List[A])(using Combinator[A]): A = ???
  def combineAll_v3[A : Combinator](list: List[A]): A = ???

  /*
    where context args are useful
    - dependency injection
    - context-dependent functionality
    - type-level programming
   */

  /*
    2 - extension methods
   */

  case class Person(name: String) {
    def greet(): String = s"Hi, my name is $name, I love scala!"
  }

  extension (string: String)
    def greet(): String = new Person(string).greet()

  val danielsGreeting = "Daniel".greet() // "type enrichment"

  // POWER
  extension [A](list: List[A])
    def combineAllValues(using combinator: Combinator[A]): A =
      list.reduce(combinator.combine)

  val theSum_v2 = aList.combineAllValues // note before it was combineAll(aList)

  def main(args: Array[String]): Unit = {
    println(anOrderedList)
    println(theSum)
    println(theSum_v2)
  }
}
