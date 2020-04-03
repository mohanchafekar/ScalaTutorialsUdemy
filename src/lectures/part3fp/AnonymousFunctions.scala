package lectures.part3fp

object AnonymousFunctions extends App{

  /*
  val doubler = new Function[Int, Int] {
    override def apply(x: Int): Int = x*2
  }
  */

  // Anonymous functions (LAMBDA)
  val doubler = (x: Int) => x*2  // This is exact equivalent expression of above function
  val doubler1: Int => Int = x => x*2 // Same as above

  // multiple params in Lambda
  val adder: (Int, Int) => Int  = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  // Careful
  println(justDoSomething) // Function itself
  println(justDoSomething()) // Actual call

  // curly braces with lambda
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // More syntactic Sugar
  // val niceIncrementer: Int => Int = (x: Int) => x + 1
  val niceIncrementer: Int => Int = _ + 1 // Same as above. Equivalent to x => x + 1

  //val niceAdder: (Int, Int) => Int = (a, b) => a + b
  val niceAdder: (Int, Int) => Int = _ + _  // Same as above. Equivalent to (a, b)=> a + b

  /*
      1. MyList: Replace all FunctionX calls with Lambda
      2. Rewrite the special added as an anonymous function... (below function)
            val superAdder: Function1 [Int, Function1[Int, Int]] = new Function1 [Int, Function1[Int, Int]]{
              override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
              override def apply(y: Int): Int = x + y
    }
   */

  //val superAdder  = (x: Int) => (y: Int) => x + y
  val superAdder: Int => (Int => Int) = x => (y => x + y) // Same as above

  val adder4 = superAdder(4)  // adder4 is a function as superAdder returns a function
  println(adder4(5))
  println(superAdder(4)(5))




}
