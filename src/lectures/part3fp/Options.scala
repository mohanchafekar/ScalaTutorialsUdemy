package lectures.part3fp

import java.util.Random

object Options extends App{

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)

  // Work with Unsafe APIs
  def unsafeMethod(): String = null
  //val result = Some(null)) //WRONG. Some should always have valid value inside. Having null in it breaks the whole point of Options
  // Instead use the Option companion apply method. It will take care of building 'Some' or 'None' depending on the value passed to it
  val result = Option(unsafeMethod()) // Some or None depending on what unsafeMethod returns
  println(result)

  //We should never check null check in Scala. Instead let Option do it

  // chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // unsafeMethod is preferred method. But in case if it returns null then the fallback option is backupMethod

  // Design unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackUpMethod(): Option[String] = Some("A valid result")
  val betterChainedResult = betterUnsafeMethod() orElse betterBackUpMethod()

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get)  // UNSAFE. Do not use this.

  // map, flatMap, filter
  println(myFirstOption.map(x => x*2))   //println(myFirstOption.map(_*2))
  println(myFirstOption.filter(x => x > 10)) // filter returns None if the predicate is false
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for-comprehensions
  /*
      Exercise
   */
  val config: Map[String, String] = Map(
    // fetched from elsewhere. So these values to will be available or may not be available.
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // In reality, it would connect to some server
  }
  object Connection{
    val random = new Random(System.nanoTime())

    // Below method returns some connection depending on host and port. here, it is returning Some or None randomly. This is a safe API
    def apply(host: String, port: String): Option[Connection] =
      if(random.nextBoolean()) Some(new Connection)
      else None
  }

  // try to establish a connection, if so - print connect method
  val host = config.get("host")
  val port = config.get("port")
  /*
     if(h != null)
        if(p != null)
            return Connection.apply(h, p)
      return null

   */
  val connection = host.flatMap(host => port.flatMap(port => Connection.apply(host, port)))

  /*
      if(c != null)
        return c.connect
      return null
   */
  val connectionStatus = connection.map(c => c.connect)

  /*
    if (connectionStatus == null)
      print null
    else print (Some(ConnectionStatus.get))
   */
  println(connectionStatus)

  /*
      if (status != null)
        println(status)
   */
  connectionStatus.foreach(println)

  //short hand solution for above. Chain of map and flatmap
  // Chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection.apply(host, port))
      . map(connection => connection.connect))
      .foreach(println)

  // For comprehensions
  val forConnectedStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection.apply(host, port)
  } yield connection.connect

  forConnectedStatus.foreach(println)

}
