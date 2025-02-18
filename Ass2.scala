// Assignment 2: Basic Types and Operations

object BasicTypesAndOperations extends App {
  // Variable Declarations
  val immutableInt: Int = 10
  var mutableDouble: Double = 20.5
  val immutableBoolean: Boolean = true

  println(s"Immutable Int: $immutableInt, Mutable Double: $mutableDouble, Immutable Boolean: $immutableBoolean")

  // Uncommenting the below line will cause a compilation error
  // immutableInt = 15 // ERROR: reassignment to val

  // Arithmetic Operations
  def add(a: Int, b: Int): Int = a + b
  def subtract(a: Int, b: Int): Int = a - b
  def multiply(a: Int, b: Int): Int = a * b
  def divide(a: Int, b: Int): Either[String, Int] =
    if (b == 0) Left("Cannot divide by zero") else Right(a / b)

  // Logical Operations
  def and(a: Boolean, b: Boolean): Boolean = a && b
  def or(a: Boolean, b: Boolean): Boolean = a || b
  def not(a: Boolean): Boolean = !a

  // Unit Tests
  assert(add(5, 3) == 8, "Addition failed")
  assert(subtract(10, 4) == 6, "Subtraction failed")
  assert(multiply(3, 3) == 9, "Multiplication failed")
  assert(divide(10, 2) == Right(5), "Division failed")
  assert(divide(10, 0) == Left("Cannot divide by zero"), "Division by zero handling failed")
  assert(and(true, false) == false, "Logical AND failed")
  assert(or(true, false) == true, "Logical OR failed")
  assert(not(true) == false, "Logical NOT failed")
  
  println("All tests passed!")
}
