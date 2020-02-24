package lectures.part3fp

object WhatsAFunction extends App{

  // Dream: use functions as a first class elements
  // problem: OOP. JVM is naturally built to support OOP

  trait MyFunction[a, b]{
    def apply(element:a): b = ???
  }

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element*2
  }
  println(doubler(2))
  // Though doubler is an instance to MyFunction, it is used like a function

  // Scala by default provides provides Function Types from 1 to 22
  // Function Type = Function1[A, B]

  val stringToInteger = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(stringToInteger("3") + 4)

  val adder = new Function2[Int, Int, Int]{
    override def apply(a: Int, b: Int) : Int = a + b
  }

  val adder1: Function2[Int, Int, Int] = new Function2[Int, Int, Int]{
    override def apply(a: Int, b: Int) : Int = a + b
  }

  val adder2: ((Int, Int) => Int)= new Function2[Int, Int, Int]{
    override def apply(a: Int, b: Int) : Int = a + b
  }

  println(adder(1, 2))
  println(adder1(1, 3))
  println(adder2(1, 4))
  // adder 2 is syntactic sugar for adder and adder1. All 3 are same
  // Functional Types Function2[A, B, R] ==== (A, B) => R

  // ALL SCALA FUNCTIONS ARE OBJECT (OR INSTANCES) OF THE CLASSES Function1, Function2 etc


  /*
     1. A function which takes 2 strings and concatenates them
     2. Transform MyPredicate and MyTransformer into function types
     3. define a function which takes and int and returns another function which takes an int and returns an int
        - what's the type of this function
        - how to do it
   */

  val concatentor: (String, String) => String = new Function2[String, String, String] {
    override def apply (a: String, b : String): String = a + b
  }
  println(concatentor("X", "Y"))


  // Higher-order functions : Functions either receive the functions as parameter OR returns a function
  // Function1 [Int, Function1[Int, Int]]

  val superAdder: Function1 [Int, Function1[Int, Int]] = new Function1 [Int, Function1[Int, Int]]{
    override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder4 = superAdder(4)  // adder4 is a function as superAdder returns a function
  println(adder4(5))
  println(superAdder(4)(5)) // Same as above
  // Function like superAdder are called as "curried function". Curried functions have the property that they can be called by multiple parameters list



}
