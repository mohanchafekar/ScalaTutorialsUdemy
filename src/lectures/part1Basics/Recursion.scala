package lectures.part1Basics

import scala.annotation.tailrec

object Recursion extends App{

  def factorial (n : Int) : Int = {
    if( n <= 1 ) n;
    else {

      println ("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n*factorial(n - 1)
      println("Computed factorial of "+ n)

      result
    }
  }

  //println(factorial (5000))


  def anotherFactorial (n: Int): BigInt = {

    def factHelper (x: Int, accumulator: BigInt): BigInt =
      if(x <= 1) accumulator
      else factHelper(x-1, x*accumulator)  //TAIL Recursion = use recursive call as the last expression

      factHelper(n, 1)
  }
  //println(anotherFactorial(5000))

  /* Concatenate a string n times*/

  def concatenateString (str: String, n:Int) : String = {
    @tailrec
    def conHelper(accumulator: String, x: Int): String =
      if (x <= 1) accumulator
      else conHelper(accumulator + str + "|", x - 1)

      conHelper(str, n)
  }
  //println(concatenateString("Mohan", 3))

  def Fibonacci (n: Int): Int = {

    def FibHelper(x: Int, last: Int, nextToLast: Int): Int =
      if (x >= n) last
      else FibHelper(x+1, last + nextToLast, last)

      if(n<=2) 1
      else FibHelper(2, 1, 1)
  }

  println(Fibonacci(8))
}
