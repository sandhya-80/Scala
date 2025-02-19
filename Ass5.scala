object FunctionsAndClosures extends App {
  // 1. Function Definitions
  def computeArea(r: Double): Double = math.Pi * r * r

  // 2. Anonymous Functions
  val sortDescending: List[Int] => List[Int] = _.sortWith(_ > _)

  // 3. Closures
  def makeAdder(x: Int): Int => Int = (y: Int) => x + y

  // Unit Tests with Edge Cases
  assert(computeArea(0) == 0, "computeArea failed for radius 0")
  assert(math.abs(computeArea(1) - math.Pi) < 1e-6, "computeArea failed for radius 1")
  assert(math.abs(computeArea(2) - (math.Pi * 4)) < 1e-6, "computeArea failed for radius 2")

  assert(sortDescending(List()) == List(), "sortDescending failed for empty list")
  assert(sortDescending(List(1)) == List(1), "sortDescending failed for single-element list")
  assert(sortDescending(List(1, 5, 3, 2, 4)) == List(5, 4, 3, 2, 1), "sortDescending failed")
  assert(sortDescending(List(10, -1, 2, 8, 5)) == List(10, 8, 5, 2, -1), "sortDescending failed")

  val add5 = makeAdder(5)
  assert(add5(0) == 5, "makeAdder failed for 0 input")
  assert(add5(10) == 15, "makeAdder failed for positive input")
  assert(add5(-5) == 0, "makeAdder failed for negative input")
  assert(makeAdder(-3)(3) == 0, "makeAdder failed for negative base value")
  
  println("All tests passed!")
}
