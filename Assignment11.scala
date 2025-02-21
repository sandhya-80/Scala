object ListOperations extends App {
  // Task 1: List Operations
  val numbers: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  // Double each element
  val doubled: List[Int] = numbers.map(_ * 2)
  println(s"Doubled List: $doubled") 

  // Filter out even numbers
  val oddNumbers: List[Int] = numbers.filter(_ % 2 != 0)
  println(s"Filtered Odd Numbers: $oddNumbers")  

  // Calculate the sum of elements
  val sum: Int = numbers.reduce(_ + _)
  println(s"Sum of Elements: $sum")  

  // Task 2: Recursive Function to Sum List
  def sumList(lst: List[Int]): Int = lst match {
    case Nil     => 0 
    case x :: xs => x + sumList(xs)  
  }
  println(s"Sum using Recursion: ${sumList(numbers)}")  
  
  // Task 3: Demonstrating Immutability
  // Attempting to modify a list directly will cause a compilation error
  // numbers(0) = 100 //------->Error
  val newList = numbers.updated(0, 100)  
  println(s"Original List: $numbers")  
  println(s"Modified List: $newList")  
  
  // Task 4: Validation (Unit Testing)
  assert(doubled == List(2, 4, 6, 8, 10, 12, 14, 16, 18, 20))
  assert(oddNumbers == List(1, 3, 5, 7, 9))
  assert(sum == 55)
  assert(sumList(numbers) == 55)
  assert(newList.head == 100 && numbers.head == 1)  // Original list remains unchanged

  println("All tests passed!")
}
