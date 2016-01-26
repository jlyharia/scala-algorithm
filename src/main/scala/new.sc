object Session {

  def abs(x: Double) = if (x < 0) -x else x;

  def sqrtIter(guess: Double, x: Double): Double = {
    if (isGoodEnough(guess, x)) return guess
    else return sqrtIter(improve(guess, x), x)
  }

  def isGoodEnough(guess: Double, x: Double): Boolean = {
    return abs(guess * guess - x) / x < 0.001
  }

  def improve(guess: Double, x: Double): Double = {
    guess - guess / 2.0
    //    (guess + x / guess) / 2
  }

  def sqrt(x: Double) = sqrtIter(1.0, x)


//  1.0 - 1.0/2
//  (1.0+2.0/1.0)/2
}