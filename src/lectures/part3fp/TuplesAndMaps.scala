package lectures.part3fp

import scala.annotation.tailrec

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


  /*
    1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900?
    2. Overly simplified social network based on Maps
        Person = String
        - add a person to the network
        - remove
        - friend (mutual)
        - unfriend (mutual)

        - number of Friends of a person
        - person with most friends
        - how many people have NO friends
        - if there is a social connection between 2 people, direct or not
   */

  val newJim = "JIM" -> 900
  val newPhonebook1 = phonebook + newJim

  println(newPhonebook1.map(pair => pair._1.toLowerCase -> pair._2))


  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if(friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")

  println(network)
  println(friend(network, "Mary", "Bob"))
  println(unfriend(friend(network, "Mary", "Bob"), "Bob", "Mary"))
  println(remove(friend(network, "Mary", "Bob"), "Bob"))


  // Jim, Bob, Mary. Jim and Bob are friends, Bob and Mary are friends, Jim and Mary are NOT friends
  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Jim", "Bob")
  val testNet = friend(jimBob, "Mary", "Bob")
  println(testNet)

  //Method to find no of friends of a person
  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if(!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Bob"))

  // Method to find who has most friends
  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  //How many people have No friends
  def nPoepleWithNoFriends(network: Map[String, Set[String]]): Int =
    //network.filterKeys(k => network(k).size == 0).size
    network.filterKeys(k => network(k).isEmpty).size   // IDE suggested to use isEmpty instead of network(k).size == 0
    // instead of filtering on keys, it can be filtered on pairs as well
    // Below are alternative implementations
    //network.filter(pair => pair._2.isEmpty).size
    //network.count(pair => pair._2.isEmpty) // IDE suggested to use count instead of filter and isEmpty
    // network.count(_._2.isEmpty)

  println(nPoepleWithNoFriends(testNet))

  // Social connection between 2 persons
  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    // Use Breadth first Search (BFS)
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if(discoveredPeople.isEmpty) false
      else {
        //consider a person in discoveredPeople
        val person = discoveredPeople.head

        if (person == target) true  //else above consideredPeople contains above person call bfs with same parameters but use discoveredPeople.tail
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person) )
      }
    }

    // Call bfs. Here we need to find social connection of b with a.
    // Hence target = b
    // We haven't considered any people to start with. Hence consideredPeople = empty set
    // discoveredPeople to start with will be a's direct friends and a itself
    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNet, "Jim", "Mary"))
  println(socialConnection(network, "Bob", "Mary"))

}
