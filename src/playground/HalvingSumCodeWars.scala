package playground

/*
  Given positive integer n, calculate following sum
  n + n/2 + n/4 + n/8 +.....+ 1
  e.g. 25 => 25 + 12 + 6 + 3 + 1
 */
object HalvingSumCodeWars extends App{

  def halvingSum(n: Int): Int = {

    if(n < 1 ) return -1
    else if(n == 1) return 1
    else n + halvingSum(n/2)

  }

  println(halvingSum(25))
  println(halvingSum(4))
  println(halvingSum(1))
  println(halvingSum(0))

}
