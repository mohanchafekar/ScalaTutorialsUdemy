package lectures.part2oop

object AnonymousClasses extends App{

  abstract class Animal{
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal = new Animal {
    override def eat: Unit = print("Haaahaaahaaa!!!")
  }

  /*
  equivalent with

  class AnonymousClasses$$anon$1 extends Animal{
    override def eat: Unit = print("Haaahaaahaaa!!!")
  }
  val funnyAnimal = new AnonymousClasses$$anon$1
  */

  println(funnyAnimal.getClass)

}
