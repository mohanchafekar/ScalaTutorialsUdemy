package lectures.part2oop

object Exceptions extends App{

  val x: String = null
  // println(x.length)
  //this ^^ will crash with NPE

  // 1. throwing exception
  //val aWeiredValue: String = throw new NullPointerException

  // throwable classes extends Throwable Class
  // Exception and Error are the major Throwable subtypes

  // 2. how to catch an exception
  def getInt(withException: Boolean): Int =
    if(withException) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try{
    // code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught a Runtime exception")
  } finally {
    // Code that will get executed NO MATTER WHAT
    // Optional
    // does not influence the return type of the expression
    // use finally only for side effects
    println("finally")
  }

  println(potentialFail)


  // 3. How to define your own exception
  class MyException extends Exception
  val exception = new MyException
  //throw exception

  /*
    1. Crash your program with OutOfMemoryError
    2. Crash with Stack overflow Error (SOError)
    3. PocketCalculator
        - add(x, y)
        - subtract(x, y)
        - multiply(x, y)
        - divide(x, y)

        Throw
         - OverFlowException if add(x, y) exceeds Int.MAX_VALUE
         - UnderFlowException if subtract(x, y) exceeds Int.MIN_VALUE
         - MathCalculationException for division by 0
   */

  // 1. OOM
  //throw new OutOfMemoryError
  //val array = Array.ofDim(Int.MaxValue)

  // 2. SO
  def infinite: Int = 1 + infinite
  //val noLimit = infinite

  // 3.
  class PocketCalculator {

    def add(x:Int, y: Int): Int = {
      val result = x + y

      if(x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderFlowException
      else result
    }
    def subtract (x:Int, y: Int): Int ={
      val result = x - y

      if(x > 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else result
    }

    def multiply(x:Int, y: Int): Int ={
      val result = x * y

      if(x > 0 && y > 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y < 0 && result < 0) throw new OverFlowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderFlowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderFlowException
      else result
    }

    def divide(x:Int, y: Int): Int =
      if (y==0) throw new MathCalculationException
      else x/y
  }

  class OverFlowException extends RuntimeException
  class UnderFlowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  val pocketCalculator = new PocketCalculator

  println(pocketCalculator.add(1, 2))

  println(pocketCalculator.subtract(Int.MinValue, 2))

  println(pocketCalculator.multiply(1, 2))

  println(pocketCalculator.divide(1, 0))


}
