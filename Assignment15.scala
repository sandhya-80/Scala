object TypeParameterizationDemo extends App {
  
  // 1. Generic Class
  class Container[T](private var value: T) {
    def getItem: T = value
    def setItem(newValue: T): Unit = { value = newValue }
  }
  
  val intContainer = new Container(10)
  val stringContainer = new Container("sandhya")
  
  println(intContainer.getItem)  
  println(stringContainer.getItem) 
  
  // 2. Variance Examples
  class Animal {
    def speak(): Unit = println("Animal speaks")
    override def toString: String = "Animal"
  }
  class Dog extends Animal {
    override def speak(): Unit = println("Dog barks")
    override def toString: String = "Dog"
  }
  class Cat extends Animal {
    override def speak(): Unit = println("Cat meows")
    override def toString: String = "Cat"
  }
  
  // Covariant class (+T allows subtypes)
  class CovariantContainer[+T](val value: T) {
    def get: T = value
  }
  val dogContainer: CovariantContainer[Dog] = new CovariantContainer(new Dog)
  val animalContainer: CovariantContainer[Animal] = dogContainer 
  animalContainer.get.speak()
  
  // Contravariant class (-T allows supertypes)
  class ContravariantContainer[-T] {
    def accept(value: T): Unit = println(s"Accepted value: $value")
  }
  val animalContravariant: ContravariantContainer[Animal] = new ContravariantContainer[Animal] 
  animalContravariant.accept(new Dog) // Now properly accepting Dog instances
  
  // 3. Type Bounds
  class Cage[T <: Animal](val animal: T) { // Upper bound (T must be a subtype of Animal)
    def makeSound(): Unit = animal.speak()
  }
  val dogCage = new Cage(new Dog)
  dogCage.makeSound()
  
  def printAnimalName[T >: Dog](value: T): Unit = println(value.toString) // Lower bound (T must be Dog or its supertype)
  printAnimalName(new Animal) 
  printAnimalName(new Dog) 
  
  // 4. Validation with Unit Tests
  assert(intContainer.getItem == 10, "Integer container failed")
  assert(stringContainer.getItem == "sandhya", "String container failed")
  assert(dogContainer.get.isInstanceOf[Dog], "Covariant container failed")
  
  println("All type parameterization tests passed!")
}
