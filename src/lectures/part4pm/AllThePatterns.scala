package lectures.part4pm

import excercises.{Cons, MyList, Empty}

object AllThePatterns extends App{

  /*
  // 1 - Constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "The One"
    case "Scala" => "The Scala"
    case true => "The Truth"
    case AllThePatterns => " A singleton object"
  }

  // 2 - Match Anything
  // 2.1 wildcard
  val matchAnything = x match {
    case _ =>
  }

  // 2.2 Variable
  val matchAVariable = x match {
    case something => s"I have found $something"
  }

  // 3 - tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"I have found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) => s"I have found $v"
  }
  // Pattern matches can be nested

  // 4 - case classes - Constructor pattern
  // PMs can be nested with Cases classes
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty =>
    case Cons(head, tail) =>                  // head will be matched to 1 and tail to Cons(2, Empty)
    case Cons(head, Cons(subhead, subtail)) =>    // head will be matched to 1, subhead to 2 and subtail to Empty
  }

  // 5 - list patterns
  val aStandardList = (1, 2, 3, 42)
  val standardListMatching = aStandardList match {
    case List (1, _, _, _) =>   // extractor - advanced
    case List (1, _*) =>   // list of arbitrary length - advanced
    //case 1 :: List(_) =>  // infix pattern
    case List(1, 2, 3) :+ 42 =>  // infix pattern
  }

  // 6 - Type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] =>   // Explicit type specifier
    case _ =>
  }

  // 7 - name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) =>   // name binding => use the name later (here). name of the pattern is nonEmptyList
    case Cons(1, rest @Cons(2, _)) =>   //  name binding inside nested pattern
  }


  // 8 - multi-patterns
  val multipatterns = aList match {
    case Empty | Cons(0, _) =>  // Compound pattern (multi pattern). | is similar to OR
  }

  // 9 - if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement%2 == 0 =>
  }
 */
  // ALL

  /*
    Question
   */
  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match {
    case listOfString: List[String] => "a list of String "
    case listOfInt: List[Int] => "a list of Integers"
    case _ => ""
  }

  println(numbersMatch)

  // JVM trick question

}
