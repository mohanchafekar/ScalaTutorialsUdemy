package lectures.part3fp

object MapFlatmapFilterFor extends App{

  val list = List(1, 2, 3)  //This is a standard library for List. List is created by calling apply method on List companion object
  println(list)
  println(list.head)
  println(list.tail)

  //map
  println(list.map( _ + 1))
  println(list.map( _ + " is a number"))

  //filter
  println(list.filter(_ % 2 == 0)) // Same as below
  //  val evenNo: Int => Boolean = x => x % 2 == 0
  //  println(list.filter(evenNo))

  //flatMap
  val toPair: Int => List[Int] = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // print all the combinations between two list
  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  // List ("a1", "a2",....."d4")
  val colors = List("black", "white")

  // Iteration
  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  // numbers list is traversed. Then for each element of Numbers, chars list is traversed and then using the final string is obtained using n and c.
  // This can be very easily done using 2 loops in imperative programming
  println(combinations)

  val combinations1 = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations1)


  //forach.......It receives a function returning Unit
  list.foreach(println)

  // for-comprehension
  val forCombination1 = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color
  // Above expression is same as below
  // val combinations1 = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  // Expression after yield is same as output of map section in above line i.e. "" + c + n + "-" + color

  println(forCombination1)

  // We can put if guard in the comprehension i.e. filters before the actual output

  val forCombination1withFilter = for {
    n <- numbers if (n % 2 == 0)
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  // Above expression is similar as
  // val forCombination1withFilter = numbers.filter(_ % 2 == 0)flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))

  println(forCombination1withFilter)

  // We can do side effects like foreach using for comprehensions
  for{
    n <- numbers
  } println(n)

  // syntax overload
   val doubleList = list.map { x =>
     x * 2
   }
    // Above is same as
    // val doubleList = list.map( _ * 2)
  println(doubleList)





  /*
      1. MyList supports for Comprehensions ----------> Answer is "Yes". For comprehensions to work below conditions should be satisfied
          map(f: A => B) => MyList[B]
          filter(p: A => Boolean) => MyList[A]
          flatMap(f: A => MyList[B]) => MyList[B]

      2. A small collection of at most ONE element  - Maybe [+T]
          - map, flatMap, filter
   */


}
