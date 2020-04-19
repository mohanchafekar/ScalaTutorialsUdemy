package lectures.part3fp

import scala.util.Random

object Sequences extends App{

  // Sequences
  val aSequence = Seq(1, 0, 2, 3, 4) // Call apply method of Seq companion object
  println(aSequence) // This prints List
  // Seq companion object  apply factory method can construct subclasses

  println(aSequence.reverse)
  println(aSequence(2))
  // Above is apply method of Sequence which "gets" value at the number (This is a get method)

  println(aSequence ++ Seq(5, 6, 7)) // This is a concatenation method
  println(aSequence.sorted)

  // Ranges. Ranges are sequences
  val aRange: Seq[Int] = 1 to 10
  val aRange1: Seq[Int] = 1 until  10  // This is extremely useful in practice for short script like Scala code
  println(aRange)
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello")) // This cab be used instead of using recursive functions

  // Lists
  val aList = List(1, 2, 3, 4)
  val prepended = 42 :: aList  // This is syntactic sugar for ::.apply(42). :: is the name of the class
  println(prepended)

  val aList1 = List(1, 2, 3, 4)
  val prepended1 = 42 +: aList  // This is syntactic sugar for ::.apply(42). :: is the name of the class
  println(prepended1)

  val appended = 42 +: aList :+ 89   // : is always on the side of list
  println(appended)

  val apples5 = List.fill(5)("Apples")   // fill is a curried functions which creates the list of same value "n" time
  println(apples5)
  println(aList.mkString("-|-"))


  // Arrays - Equivalent of Java Arrays. They are mutable. It is a direct mapping to Java Array
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3) // This creates an empty array which can hold 3 values
  println(threeElements)
  threeElements.foreach(println) // Prints default values

  // Mutation
  numbers(2) = 0  // Syntactic Sugar for numbers.update(2, 0). Update is a special method in Scala similar to apply
  println(numbers.mkString(" "))

   // Array and Seq
  val numbersSeq: Seq[Int] = numbers // Implicit conversion
  println(numbersSeq)
  // Though arrays are Java array and are not connected to Seq, they can be mapped. WrappedArray(1, 2, 0, 4)

  // Vectors
  val vector: Vector[Int] = Vector(1, 2, 3, 4)
  println(vector)

  // Vectors Vs Lists

  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  //Keep references to the Tail
  // updating the reference in the middle takes a long time
  println(getWriteTime(numbersList))

  //depth of a tree is small
  // needs to replace entire 32 bit chunk
  println(getWriteTime(numbersVector))


}
