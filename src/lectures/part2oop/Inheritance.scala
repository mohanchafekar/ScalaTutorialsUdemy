package lectures.part2oop

object Inheritance extends App {

  // Single class inheritance
  class Animal{
      protected def eat = println("nomnom")
  }

  class Cat extends Animal{
      def crunch = {
        eat
        println("Crunch crunch")
      }
  }

  val cat = new Cat
  //cat.eat    // This is not accessible outside the subclass
  cat.crunch


  // Constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)
  class Boy(name: String, age: Int, idCard: String) extends Person(name)

  //Overriding
  class Dog extends Animal{
    override def eat = println("Dog is eating")
  }
  val dog = new Dog
  dog.eat

  //preventing overriding
  // 1. Use final keyword on the member
  // 2. Use final keyword on entire class
  // 3. Seal the class with keyword Sealed. extend class in this file, but prevent extension on other files

}
