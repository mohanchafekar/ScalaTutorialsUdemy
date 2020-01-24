package lectures.part1Basics

object Functions extends App{

  def aFunction (a : String , b : Int) :  String = {
    a + " " + b
  }
  println(aFunction("Hello", 3))


  //Parameter less functions can be called with just their names
  def aParameterLessFunction () : Int = 42
  println(aParameterLessFunction())
  println(aParameterLessFunction)


  //RECURSION

  def aRepeatedFunction (aString : String, n: Int) : String = {
    if( n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("Hello", 3))

  //WHEN YOU NEED A LOOP, USE RECURSION

  //Function with Side Effects
  def aFunctionWithSideEffects (aString : String) : Unit = println(aString)

  // Function with the code block which has another function inside it
  def aBigFunction (n:Int) :Int ={

    def aSmallFunction (a : Int, b : Int) : Int = a + b

    aSmallFunction(n, n-1)
  }

  println(aBigFunction(5))

  /* A Greeting Function */
  def aGreetingFunction (name : String, age : Int): String = {
    "Hi. My name is " + name + " and I am " + age + " years old."
  }

  println(aGreetingFunction("Mohan", 38))


  /* A Factorial Function */
  /*             1 * 2 * 3 * 4 *........* n       */

  def aFactorialFunction (n : Int) : Int = {

    if (n <= 0) 1
    else n * aFactorialFunction(n-1)
  }
  println(aFactorialFunction(4))


  /* A Fibonacci Function */
  /*
   f(1) = 1
   f(2) = 1
   f(n) = f(n -1) + f(n-2)
   */
  def aFibonacciNumber( n : Int) : Int = {

    if((n == 1) || (n == 2)) 1
    else  aFibonacciNumber(n-1) + aFibonacciNumber(n-2)
  }
  println(aFibonacciNumber(7))


  /* A function to find if the number is prime number or not*/
  def isPrime ( n : Int) : Boolean = {

    def isPrimeUntil ( t : Int) : Boolean = {
      if(t<=1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }

    isPrimeUntil(n/2)
  }

  println(isPrime(8))
}
