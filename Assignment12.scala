import scala.collection.mutable

object CollectionOperations extends App {
  // Task 1: Sets
  val sentence = "This is assignment number 12 on the Scala because Scala is powerful"
  val wordsSet: Set[String] = sentence.split(" ").toSet
  println(s"Unique words: $wordsSet") 
  val Set2 = Set("Scala", "is", "new", "for","me","and","Scala","is","very","powerful")
  val unionSet = wordsSet union Set2
  val intersectionSet = wordsSet intersect Set2

  println(s"Union: $unionSet")         // Merged words from both sets
  println(s"Intersection: $intersectionSet") // Common words

  // Task 2: Maps (Word Count Function)
  def wordCount(text: String): Map[String, Int] = {
    text.split("\\s+").map(_.toLowerCase).groupBy(identity).view.mapValues(_.length).toMap
  }

  val wordCounts = wordCount(sentence)
  println(s"Word Count: $wordCounts")  
  // Task 3: Vectors (Efficient Index Access)
  val numbersVector: Vector[Int] = Vector(10, 20, 30, 40, 50)
  println(s"Third element: ${numbersVector(2)}") 

  // Task 4: Validation (Unit Tests)
  assert(wordsSet == Set("number", "12","is", "This", "Scala", "because", "on", "powerful", "assignment", "the"))
  assert(unionSet.contains("12") && unionSet.contains("on"))
  assert(intersectionSet == Set("Scala", "powerful","is"))

  assert(wordCounts("scala") == 2)
  assert(wordCounts("powerful") == 1)

  assert(numbersVector(2) == 30)

  // Demonstrating Mutability
  val mutableSet = mutable.Set(1, 2, 3)
  mutableSet += 4  // Allowed
  println(s"Mutable Set: $mutableSet") 

  val immutableSet = Set(1, 2, 3)
  // immutableSet += 4          //  Compilation error (immutable)

  println("All tests passed!")
}
