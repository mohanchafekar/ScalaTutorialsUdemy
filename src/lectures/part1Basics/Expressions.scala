package lectures.part1Basics

object Expressions extends App {

    val x = 1+2 //EXPRESSIONS
    println(x)

    // Mathematical Expressions
    println(2+3*4)

    //+ - * / & | ^ << >> >>> (right shift with zero extension)

    //Logical Expressions
    println (1==x)
    // == != > >= < <=


    var aVariable = 2
    aVariable+=3   //Also works with -=, *=, /=  This works with Var........side effects
    println(aVariable)



    // Instructions (DO) Vs Expressions (Value)
    // Instructions (Doing something) think imperative language like Java
    //Expression has value AND Or a Type think functional language like Scala


    //If Expression
    val aCondition = true
    val aConditionedValue = if(aCondition) 5 else 3 //If Expression
    println(aConditionedValue)


    //LOOPS
    var i = 0
    while (i<4){
      println(i)
      i+=1
    }
    // NEVER WRITE THIS AGAIN. Because loops are generally very specific to Imperative programming like Java

    // EVERYTHING is Scala is an Expression

    val aWeiredValue = (aVariable = 3) //  It's Type is Unit. Hover over the variable. It is equivalent to void

    println(aWeiredValue)

    // Side Effects : println90, whiles, reassigning

    // Code Blocks
    val aCodeBlock = {
      val y = 2
      val z = y +1

      if (z > 2) "hello" else "Good Bye"
    }

    //Code block is an expression and value of the code block is the val if the last statement in the block. In this case it is value of the if statement that is String
    //Anything written in the code block is not visible outside

}
