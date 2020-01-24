package lectures.part2oop

object OOBasics extends App{

  val person1 = new Person1("John", 26)
  println(person1.age)

  val person = new Person("John", 26)
  println(person.x)
  println(person.greet("David"))
  println(person.greet())
}

//Constructor
class Person1 (name: String, val age: Int)
// Class parameters are NOT Fields
//To convert the parameters into fields add val or val to it

class Person (name: String, val age: Int = 0){
//body
  val x = 2

  println(1 + 3)

  //method
  def greet(name: String): Unit = println(s"${this. name} says: Hi $name")

  //Overloading
  def greet(): Unit = println(s"Hi : I am $name")

  //Multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
  //Default parameters work with constructor as well

}
