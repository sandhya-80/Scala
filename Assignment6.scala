object ControlAbstraction extends App {
  // 1. Custom Control Structure
  def repeat(n: Int)(block: => Unit): Unit = {
    require(n >= 0, "n must be non-negative")
    for (_ <- 1 to n) block
  }

  // 2. Resource Management
  class Resource {
    def use(): Unit = println("Using resource")
    def close(): Unit = println("Resource closed")
  }

  def using[T <: { def close(): Unit }](resource: T)(block: T => Unit): Unit = {
    try {
      block(resource)
    } finally {
      resource.close()
    }
  }

  // Unit Tests
  var count = 0
  val output = new java.io.ByteArrayOutputStream()
  Console.withOut(output) {
    repeat(5) { count += 1 }
    assert(count == 5, "repeat function failed")
  }

  val resourceList = List(new Resource, new Resource)
  Console.withOut(output) {
    resourceList.foreach { resource =>
      using(resource) { _.use() }
    }
  }

  println(s"Resources Used: $resourceList")
  println(output.toString)
  println("All tests passed!")
}
