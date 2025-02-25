object ScalaEnums extends App {
  enum Day:
    case Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday

  enum Planet(val mass: Double, val radius: Double):
    case Mercury extends Planet(3.285e23, 2.4397e6)
    case Venus extends Planet(4.867e24, 6.0518e6)
    case Earth extends Planet(5.972e24, 6.371e6)
    case Mars extends Planet(6.39e23, 3.3895e6)
    case Jupiter extends Planet(1.898e27, 6.9911e7)
    case Saturn extends Planet(5.683e26, 5.8232e7)
    case Uranus extends Planet(8.681e25, 2.5362e7)
    case Neptune extends Planet(1.024e26, 2.4622e7)

    def surfaceGravity: Double = (6.67430e-11 * mass) / (radius * radius)

  // Unit Tests
  assert(Day.Monday.toString == "Monday", "Day enum failed")
  assert(Day.Sunday.toString == "Sunday", "Day enum failed")
  
  assert(Planet.Earth.surfaceGravity > 0, "Earth gravity calculation failed")
  assert(Planet.Mars.surfaceGravity > 0, "Mars gravity calculation failed")
  assert(Planet.Jupiter.surfaceGravity > 0, "Jupiter gravity calculation failed")

  // Printing values
  println("Enum values:")
  Day.values.foreach(day => println(s"Day: $day"))
  
  println("\nPlanet surface gravities:")
  Planet.values.foreach(planet => println(s"${planet.toString}: ${planet.surfaceGravity} m/s²"))
  
  println("\nAll enum tests passed!")
}
