package lectures.part1Basics

object CBNvsCBV extends App{

  def calledByValue(x: Long) = {

    println("by Value : "+x)
    println("by Value : "+x)
  }

  def calledByName(x: =>Long) ={

    println("by Name : "+x)
    println("by Name : "+x)

    /*
    * Above statement is similar to
    *  println("by Name : "+System.nanoTime())
    * */
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printfirst(x: Int, y: => Int) = print(x)

  //printfirst(infinite(), 34)
  printfirst(34, infinite())

}
