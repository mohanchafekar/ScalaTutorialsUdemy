package playground


/*
    Create a function called one that accepts two parameters
      - a sequence
      - a function

     And returns true only if the function in the params returns true for exactly one (1) item in the sequence
 */

object SequenceAndFunctionCodeWars extends App{

    def one[A](list: List[A],f: (A => Boolean)): Boolean = {
      if(list.size == 0) false
      else {
        var temp: Int = 0
        for{
          n <- list
        }yield {
          if(f(n)) temp = temp + 1
        }
        if(temp == 1) true
        else false
      }

    }

    val isEven: (Int => Boolean) = (x: Int) => {
      if (x % 2 == 0) true
      else false
    }
    val aList = List(1, 2, 3, 4)
    println(one(aList, isEven))

   val length3: (String => Boolean) = str => {
     if(str.length == 3) true
     else false
   }
   val bList = List("BAT", "Ball")
   println(one(bList, length3))

}
