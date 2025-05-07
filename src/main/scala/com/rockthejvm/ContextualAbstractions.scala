object ContextualAbstractions {
  /*
    1 - context parameters/arguments
   */
  val aList = List(2,1,3,4)
  val anOrderedList = aList.sorted // (ordering)

  // Ordering
  // (a,b) => a > b
  given descendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _)


  def main(args: Array[String]): Unit = {
    println(anOrderedList)
  }
}
