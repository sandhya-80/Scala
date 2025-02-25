object TypeHierarchyDemo extends App {
  // 1. Type Relationships
  val i: Any = 42
  val d: AnyVal = 5.3
  val s: AnyRef = "Sandhya"
  val l: AnyRef = List(14, 15, 16)
  
  println(s"Int as Any: $i")
  println(s"Double as AnyVal: $d")
  println(s"String as AnyRef: $s")
  println(s"List as AnyRef: $l")

  // 2. Type Casting
  def safeCast(x: Any): String = x match {
    case i: Int       => s"Integer: $i"
    case d: Double    => s"Double: $d"
    case s: String    => s"String: $s"
    case l: List[_]   => s"List: $l"
    case _            => "Unknown type"
  }

  println(safeCast(25))       
  println(safeCast(3.14))      
  println(safeCast("Pandey"))   
  println(safeCast(List(1, 2))) 
  println(safeCast(true))     
  
  // Unit Tests
  assert(safeCast(10) == "Integer: 10", "Integer casting failed")
  assert(safeCast(2.5) == "Double: 2.5", "Double casting failed")
  assert(safeCast("Test") == "String: Test", "String casting failed")
  assert(safeCast(List(4, 5)) == "List: List(4, 5)", "List casting failed")
  assert(safeCast(None) == "Unknown type", "Unknown type handling failed")
  
  println("All tests passed!")
}
