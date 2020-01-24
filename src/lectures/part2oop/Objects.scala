package lectures.part2oop

object Objects extends App{

  //  SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY ("static")
  object Person { // type + its only instance
    // "Static" / "class" level functionality
      val N_EYES = 2
      def canFly: Boolean = false

      //Factory method
      def from(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String){
    //instance level functionality
  }

  // Notice that both object and class can have same name. They are called COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = Singleton INSTANCE
  val mary = Person
  val john = Person
  println(mary==john)

  val person1 = new Person("Person1")
  val person2 = new Person("person2")
  println(person1==person2)

  val bobbie = Person.from(person1, person2)

  //Scala Applications = Scala Objects with main method
  //def main(args: Array[String]): Unit
  //Above method will turn into public static void main(args[]) by jvm

}
