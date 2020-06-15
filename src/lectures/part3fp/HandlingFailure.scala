package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  // Create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Super Failure"))

  println(aSuccess)
  println(aFailure)

  // We don't need to create a success and failure object ourselves/ Try companion object would do it

  def unsafeMethod(): String = throw new RuntimeException("No String for you......")
  // println(unsafeMethod()) =========> Program would crash here

  // Try object via the apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // syntax sugar
  val anotherPotentialFailure = Try {
    // Code that might throw
  }

  // Utilities
  println(potentialFailure.isSuccess)

  // orElse
  def backupMethod: String = "A valid result"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod))
  println(fallbackTry)

  // If you design the API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException())
  def betterFallbackMethod(): Try[String] = Success("A Valid result")
  val betterFallback = betterUnsafeMethod() orElse betterFallbackMethod()

  // map, flatMao, filter
  println(aSuccess.map(x => x*2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(x => x > 10))


  /*
      Exercise
   */
  val host = "localhost"
  val port = "8080"
  def renderHTML(page: String)= println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>.....</html>"
      else throw new RuntimeException()
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection =
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  // If you get html page from the connection, then print it on the console i.e. call renderHTML method
    val possibleConnection = HttpService.getSafeConnection(host, port)
    val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("/home"))
    possibleHTML.foreach(renderHTML)

  // Shorthand
    HttpService.getSafeConnection(host, port)
    .flatMap(connection => connection.getSafe("/home"))
    . foreach(renderHTML)

  // For comprehension version
  for{
    connection <- HttpService.getSafeConnection(host, port)
    html <- connection.getSafe("/home")
  } renderHTML(html)

  /*
      try{
        connection = HttpService.getConnection(host, port)
        try{
          page = connection.get("/home")
          renderHTML(page)
        } catch(exception){
        }
      }catch(exception){
      }

   */

}
