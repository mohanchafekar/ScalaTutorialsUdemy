package lectures.part4pm

import scala.util.Random

object PatternMatching extends App{

  // switch in steroids
  val random = new Random()
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the ONE"
    case 2 => "double or nothing"
    case 3 => "third time is a charm"
    case _ => "Something else"   // _ = wildcard
  }

  println(x)
  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, My name is $n and I can't drink in US" // if a < 21 is called as guard
    case Person(n, a) => s"Hi, My name is $n and I am $a years old" // decomposed (extracted) values from the object of the case class
    case _ => "I don't know who I am"
  }

  println(greeting)

  /*
      1. cases are matched in order
      2. what if no cases match? Match Error. Hence use wild card
      3. types of the PM expressions? unified type of all the types in all the cases
      4. PM works really well with case classes
   */

  // PM on sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal

  // On compiling this class it would give us a warning which we won't get if we use normal class instead of sealed class
  val animal: Animal = new Dog("Terra Nova")
  animal match{
    case Dog(someBreed) => println(s"Matched a dog of $someBreed breed")
  }

  // Match everything
  val isEven = x match{
    case n if n % 2 == 0 => true
    case _ => false
  }
  // WHY??? This is an overkill

  /*
    Exercise
    Simple function uses PM
    takes an Expr => Human readable form

    Sum(Number(2), Number(3)) => 2 + 3
    Sum(Number(2), Number(3), Number(4)) => 2 + 3 + 4
    Prod(Sum(Number(2), Number(1)), Number(3)) => (2 + 1) * 3
    Sum(Prod(Number(2), Number(1)), Number(3)) => 2 * 1 + 3
   */
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => {
        def maybeShowParantheses(exp: Expr) = exp match {
          case Prod(_, _ ) => show(exp)
          case Number(_) => show(exp)
          case _ => "(" + show(exp) + ")"
        }
      maybeShowParantheses(e1) + " * " + maybeShowParantheses(e2)
    }

  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(1)), Number(3))))
  println(show(Prod(Sum(Number(2), Number(1)), Sum(Number(3), Number(4) ))))
  println(show(Sum(Prod(Number(2), Number(1)), Number(3))))

}
