// 1. Class Hierarchy
abstract class Animal {
  def speak(): String = "Some generic sound"
}

class Dog extends Animal {
  override def speak(): String = super.speak() + " Woof!"
}

class Cat extends Animal {
  override def speak(): String = super.speak() + " Meow!"
}

// 2. Composition
class Zoo {
  private var animals: List[Animal] = List()

  def addAnimal(animal: Animal): Unit = {
    animals = animals :+ animal
  }

  def makeAllSpeak(): List[String] = {
    animals.map(_.speak())
  }

  def getAnimals: List[Animal] = animals
}

// Unit Tests
object CompositionInheritanceTest extends App {
  val dog = new Dog
  val cat = new Cat
  assert(dog.speak() == "Some generic sound bark!", "Dog speak failed")
  assert(cat.speak() == "Some generic sound Meow!", "Cat speak failed")
  
  val zoo = new Zoo
  zoo.addAnimal(dog)
  zoo.addAnimal(cat)
  
  val animalSounds = zoo.makeAllSpeak()
  val animalList = zoo.getAnimals
  
  println("Animal Sounds: " + animalSounds)
  println("Animals in Zoo: " + animalList)
  
  assert(animalSounds == List("Some generic sound bark!", "Some generic sound Meow!"), "Zoo speak failed")
  
  println("All tests passed!")
}
