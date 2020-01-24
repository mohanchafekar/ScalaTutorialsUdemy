package lectures.part2oop

object MethodNotations extends App{

  class Person (val name: String, favoriteMovie: String, var age: Int = 16){
    def likes(movie: String): Boolean = movie==favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}" //Operators like +, - etc are allowed as method names in scala
    def unary_! : String = s"${name}, what the heck!"  // Make sure there is a space between ! and :. Otherwise compiler thinks they are one word
    def isAlive: Boolean = true
    def apply(): String = s"Hi! My name is ${name} and my favorite movie is ${favoriteMovie}"

    def +(str: String) : Person = new Person(name+" "+str, favoriteMovie)
    def unary_+ : Int =  age + 1
    def learns(str: String): String = s"${name} learns ${str}"
    def learnsScala: String = learns("Scala")
    def apply(no: Int): String = s"${name} watched ${favoriteMovie} ${no} times"

  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") //equivalent to above statement
  // infix notation = operator notation : Works only with the method with one parameter
  // Also called as Syntactic Sugar -  It is a nicer way to write a code which is equivalent to a more complex or cumbersome code

  //-----------------------------------------------------------------------------------------------
  //"Operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  //  ALL OPERATORS ARE METHODS IN SCALA
  //  Akka actors have ! ?
  //---------------------------------------------------------------------------------------------

  //prefix notation
  val x = -1  //Equivalent with 1.unary_-
  val y = 1.unary_-

  //Unary_ prefix only works with + - ~ !(bang operator)
  println(!mary)
  println(mary.unary_!)

  //----------------------------------------------------------------------------------------------

  //Postfix notation : Is used only for methods which has no input parameters
  println(mary.isAlive)
  println(mary isAlive)//Equivalent to above statement

  //--------------------------------------------------------------------------------------------------

  //apply  : This is only allowed for the methods which are names as "apply" with no input parameters (return type does not matter)
  println(mary.apply())
  println(mary())  //equivalent as above statement


  // Exercise
  /*
    1. Overload the + Operator
    mary + "the rockstar" => new person "Mary (the rockstar)"

    2. Add an age to person class
    Add a unary + operator  => new person with age +1
    +mary => mary with age incremented

    3. Add a "learns" method in the Person Class => "Mary learns Scala"
    Add a learnScala method, calls learn method with "Scala"
    use it in post fix notation

    4. Overload the apply method
    mary.apply(2) => "Mary watched Inception 2 times"
  */

  //1
  val  newPerson : Person = mary + "the rockstar"
  println(newPerson.name)

  //2
  println(+mary)


  //3
  println(mary learns "Java")
  println(mary learnsScala)

  //4
  println(mary(2))
}
