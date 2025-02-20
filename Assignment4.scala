// Assignment 4: Built-in Control Structures

object ControlStructures extends App {
  // Conditional Logic
  def classifyNumber(n: Int): String = {
    if (n > 0) "positive"
    else if (n < 0) "negative"
    else "zero"
  }

  // Loops
  def sumOfRange(start: Int, end: Int): Int = {
    (start to end).sum
  }

  // Pattern Matching - Simple Calculator
  def calculator(a: Int, b: Int, op: Char): Either[String, Int] = {
    op match {
      case '+' => Right(a + b)
      case '-' => Right(a - b)
      case '*' => Right(a * b)
      case '/' => if (b != 0) Right(a / b) else Left("Cannot divide by zero")
      case _   => Left("Invalid operation")
    }
  }

  // Unit Tests
  assert(classifyNumber(10) == "positive", "Classification failed")
  assert(classifyNumber(-5) == "negative", "Classification failed")
  assert(classifyNumber(0) == "zero", "Classification failed")
  
  assert(sumOfRange(1, 5) == 15, "Sum of range failed")
  assert(sumOfRange(3, 3) == 3, "Sum of single value range failed")
  
  assert(calculator(4, 2, '+') == Right(6), "Addition failed")
  assert(calculator(4, 2, '-') == Right(2), "Subtraction failed")
  assert(calculator(4, 2, '*') == Right(8), "Multiplication failed")
  assert(calculator(4, 2, '/') == Right(2), "Division failed")
  assert(calculator(4, 0, '/') == Left("Cannot divide by zero"), "Division by zero handling failed")
  assert(calculator(4, 2, '%') == Left("Invalid operation"), "Invalid operation handling failed")
  
  println("All tests passed!")
}
