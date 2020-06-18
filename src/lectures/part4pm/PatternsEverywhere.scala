package lectures.part4pm

object PatternsEverywhere extends App{

  // big idea #1
  try{
    // Code
  } catch{
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "NPE"
    case _ => "something else"
  }

  // catches are actually MATCHES
  /*

    try{
      // Code
    } catch(e){
      e match{
          case e: RuntimeException => "runtime"
          case npe: NullPointerException => "NPE"
          case _ => "something else"
      }
    }
   */

  // big idea #2
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0   // ?!
  } yield (10 * x)

  // generators are also based on PATTERN MATCHING
  val tuples = List((1, 2), (3, 4))
  val filterTuplels = for{
    (first, second) <- tuples   // first and second are decomposed in the same fashion as pattern matching would decompose tuples as all the generator are based on pattern matching
  } yield first * second
  // Advanced Scala -> Case classes, :: operators, .......


  // big idea #3 - NEW
  val tuple = (1 ,2, 3)
  val (a, b, c) = tuple
  println(b)
  // multiple value definitions based on PATTERN MATCHING
  // ALL the power

  val head :: tail = list
  println(head)
  println(tail)

  // big idea #4 - NEW
  // partial functions are based on PATTERN MATCHING
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "The One"
    case _ => "something else"
  }

  // mappedList is equivalent to mappedList2
  val mappedList2 = list.map { x => x match {
      case v if v % 2 == 0 => v + "is even"
      case 1 => "The One"
      case _ => "something else"
    }
  }

  println(mappedList)
  println(mappedList2)
}
