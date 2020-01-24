package lectures.part1Basics

object StringOps extends App{

  // Scala specific : String Interpolators

  // S - Interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age+1} years old"
  println(anotherGreeting)


  // F - Interpolators  (Formatted Strings)
  val speed = 1.2f
  val name1 = "Daniel"
  val myth = f"$name1 can eat $speed%2.2f burgers per minute"
  println (myth)

  // raw Interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
