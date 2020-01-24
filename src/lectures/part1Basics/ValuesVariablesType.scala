package lectures.part1Basics

/**
  * Created by Mohan_Chafekar on 11/16/2019.
  */
object ValuesVariablesType extends App{

    //Values
    val x = 42
    println(x)

    // VALS ARE IMMUTABLE
    //COMPILERS CAN INFER TYPES. TYPES OF VALS ARE OPTIONAL

    val aString: String = "Hello"
    val anotherSting = "GoodBye"

    val aBoolean: Boolean = false
    val aChar: Char = 'A'
    val anInt: Int = x
    val aShort: Short = 4613
    val aLong: Long = 5678678676786L
    val aFloat: Float = 2.0f
    val aDouble: Double = 3.14

    //Variables
    var aVariable: Int = 4
    aVariable = 5  //side effects

}
