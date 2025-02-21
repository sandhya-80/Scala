// Task 1: Pattern Matching with Types
def describe(x: Any): String = x match {
  case i: Int       => s"An integer: $i"
  case s: String    => s"A string: $s"
  case d: Double    => s"A double: $d"
  case l: List[_]   => "A list of elements"
  case _            => "Something else"
}

// Task 2: Case Class Matching
case class Person(name: String, age: Int)

def personInfo(person: Person): String = person match {
  case Person(name, age) => s"$name is $age years old."
}

// Task 3: Pattern Guards
def classifyNumber(n: Int): String = n match {
  case x if x % 2 == 0 && x < 10  => "small even"
  case x if x % 2 == 0 && x >= 10 => "large even"
  case x if x % 2 != 0 && x < 10  => "small odd"
  case x if x % 2 != 0 && x >= 10 => "large odd"
}

// Task 4: Validation (Test Cases)
object PatternMatchingTest extends App {
  // Testing describe function
  println(describe(22))         
  println(describe("Sandhya"))    
  println(describe(5.2))       
  println(describe(List(1, 2))) 
  println(describe(true))       

  // Testing Case Class Matching
  val person = Person("Sandhya", 25)
  println(personInfo(person))   

  // Testing Pattern Guards
  println(classifyNumber(1))   
  println(classifyNumber(20))   
  println(classifyNumber(5))    
  println(classifyNumber(40))   
}
