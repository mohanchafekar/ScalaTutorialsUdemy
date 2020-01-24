package lectures.part1Basics

object AbstractDataTypes extends App {

  //Abstract
  abstract class Animal{
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("Crunch Crunch")
  }

  //traits
  trait Carnivore{
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore{
    override val creatureType: String = "Croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I am a croc and I am eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)


  //traits Vs Abstract class
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = "behavior", abstract class ="thing"
}
