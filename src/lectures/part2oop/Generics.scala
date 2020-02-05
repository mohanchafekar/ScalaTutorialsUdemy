package lectures.part2oop

object Generics extends App{

  // Generic class
  class MyList[+A]{
     // Use the type A
    def add[B >: A](element: B) : MyList[B] = ???
    /*
       A = Cat
       B = Dog = Animal (super class in this case)
       This is the answer for the Hard question below.
       It says if a Dog is added in the list of Cat then it would become a list of Animal (superclass)
     */
  }
  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]


  // Generic Methods
  object MyList {   // objects cannot be type parameterized
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]


  // Variance Problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Can subclass be substituted for super class in the generics?

  // 1. yes. List[Cat] extends List[Animal] => COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ???  HARD QUESTION => List of cat will no longer be a list of Cat and it will be converted into list of animals

  // 2. No = INVARIANCE
  class InvariantList[A]
  val invariantList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, No!!  CONTRAVARIANCE   This is opposite relationship to COVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal] // This is not very useful in the List

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]  // This can be a better example


  // bounded Types
  class Cage[A <: Animal](animal: Animal)  //Cage will allow all subtypes of Animal and nothing else
  val cage = new Cage(new Dog)


}
