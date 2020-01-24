package lectures.part2oop

import java.util.Calendar;

object OOBasicsExcercise extends App{

    val author : Writer = new  Writer ("Mohan", "Chafekar", 1981)

    println(author.fulName)

    val novel : Novel = new Novel("Learning Scala", 2019, author)

    println("Novel is written by" + novel.author.fulName() + " And " + "Auther's age is "+ novel.authorAge + " And " + "Booked released in "+ novel.yofRelease)
    novel.copy(2020)

    println("New Year of release is " + novel.yofRelease)

}

class Writer (firstName : String, surName : String, birthYear: Int){
    val fName = firstName
    val sName = surName
    val bYear = birthYear

    def fulName () : String = firstName+" "+surName
}

class Novel (name : String, yearOfRelease : Int, writer: Writer){

    val NovelName = name
    val yofRelease = yearOfRelease
    val author : Writer = writer

    //val authorAge : int = Date.
    val isWrittenBy : String = author.fulName()

    def authorAge = yearOfRelease - writer.bYear

    def copy(newYearOfRelease : Int) : Novel = new Novel(NovelName, newYearOfRelease, author)
}


/*
    Counter Class
    - receives an int value
    - method currentCount
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */

class Counter (val count : Int) {

    def inc = new Counter(count + 1) //Immutability
    def dec = new Counter(count - 1)

    def inc(n: Int) = new Counter(count + n)
    def dec(n: Int) = new Counter(count - n)


    /*
     var currentCount : Int = count;

    def increment() : Int =  {
        currentCount =  currentCount + 1
    }
    def decrement(): Int ={
        currentCount =  currentCount - 1
    }

    def increment(part : Int) : Int =  {
        currentCount =  currentCount + part
    }

    def decrement(part : Int) : Int =  {
        currentCount =  currentCount - part
    }
    */
}
