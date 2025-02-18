// Assignment 1: Classes and Objects

// Define a Person class
class Person(val name: String, val age: Int) 
{
  def greet(): String = s"Hello, my name is $name and I am $age years old."
}

// Companion Object for Person
object Person 
{
  def apply(name: String, age: Int): Person = new Person(name, age)
}

// Testing Classes and Objects
object PersonTest extends App 
{
  // Instantiate Objects
  val person1 = new Person("Alice", 25)
  val person2 = Person("Bob", 30) // Using companion object apply method
  val person3 = new Person("Alice", 25)
  // Invoke the greet method
  println(person1.greet())
  println(person2.greet())
  
  // Unit Tests
  assert(person1.greet() == "Hello, my name is Alice and I am 25 years old.", "Greeting method failed")
  assert(person2.greet() == "Hello, my name is Bob and I am 30 years old.", "Greeting method failed")
  println("All tests passed!")
}
