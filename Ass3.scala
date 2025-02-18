// Define an immutable Point case class
case class Point(x: Int, y: Int) {
  // Method to return a new instance with updated coordinates
  def move(dx: Int, dy: Int): Point = Point(x + dx, y + dy)
}

// Testing Immutability
object PointTest extends App {
  val p1 = Point(3, 4)
  println(s"Original Point: $p1")
  
  val p2 = p1.move(2, 3)
  println(s"Moved Point: $p2")
  
  // Uncommenting the below line will cause a compilation error because case class properties are immutable
  // p1.x = 10 // ERROR: reassignment to val
  
  // Unit Test for immutability and move method
  assert(p1 != p2, "Point instance should be immutable and return a new instance")
  assert(p2.x == 5 && p2.y == 7, "move method should correctly update coordinates")
  println("All tests passed!")
}
