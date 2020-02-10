package lectures.part2oop

object CaseClasses extends App{

  /*
    equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // 1. class parameters are promoted to fields
  val jim = new Person("Jim", 34)
  println(jim.name)  // This wouldn't have been permitted if there was no "case" mentioned before class

  // 2. Sensible toString
  // println(instance) = println(instance.toString) - Syntactic Sugar
  println(jim.toString) // Print this to see the result
  println(jim)

  // 3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)  // This would have been false in normal class as the default method from anyRef would have been picked which would have equated the references

  // 4. Case classes have handy copy method which can take the named parameters
  val jim3 = jim.copy(age = 42) // This will return the new instance of Person class which is same as jim except the age which will be 42
  println(jim3)

  // 5. Cases classes have the companion objects
  val thePerson = Person  // companion object
  val mary = Person("Mary", 23) // uses apply method of the companion
  // val mary = Person.apply("Mary", 23) // Same as above  and does same things as done by constructor

  // 6. CCs are serializable  ---> espacially used in Akka

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom{
    def name: String = "The UK of GB and NI"
  }
  // Case objects have properties similar to Cases classes except they do not have companion object. They are object themselves

  /*
    Expand MyList - Use case classes and case objects wherever appropriate
   */




}
