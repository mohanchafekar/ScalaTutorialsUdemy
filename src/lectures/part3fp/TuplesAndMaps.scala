package lectures.part3fp

object TuplesAndMaps extends App{

  // tuples = finite ordered "Lists". Tuple groups things together
  var aTuple = new Tuple2(2, "Hello, Scala")  // Tuple2[Int, String] => (Int, String)
  var aTuple1 = Tuple2(2, "Hello, Scala") // Companion object
  var aTuple2 = (2, "Hello, Scala") // Syntactic sugar

  println(aTuple._1) //prints element 1
  println(aTuple._2) //prints element 2
  println(aTuple.copy(_2= "Good bye Java"))
  println(aTuple.swap) // ("Hello, Scala" , 2)


  // Map - Kay -> Value
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1)  // "Daniel" -> 789  => syntactic sugar for ("Daniel", 789)
  println(phonebook)

  // Map Ops
  println(phonebook.contains("Jim")) // Returns true if map contains Key
  println(phonebook("Jim")) // calling apply method  with key returns the corresponding value.

  // If key does not exists in above operation, it throws the exception java.util.NoSuchElementException.
  // To take care of this scenario, withDefaultValue method is used. So if the key does not exists, the default value is returned
  println(phonebook("Mary"))

  // Add a pairing. Please note that maps are immutable
  val newPairing = "Mary" -> 999
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)


  // functionals
  // Map, flatMap and filter => They take the pairings
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))  // Lower case the keys

  // filterKeys
  println(phonebook.filterKeys(x => x.startsWith("J")))
  // mapValues
  println(phonebook.mapValues(numbers => numbers*10))
  println(phonebook.mapValues(numbers => "213-" +numbers))

  // conversion to other collections
  println(phonebook.toList) // returns list of pairings
  println(List("Mohan" -> 1000).toMap) //Conversion of list of pairing to Map

  //groupBy
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim", "john")
  println(names.groupBy(name => name.charAt(0)))



}
