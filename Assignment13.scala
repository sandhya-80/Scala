import scala.collection.mutable

// Task 1: Implementing a Stack with ArrayBuffer
class MutableStack[T] {
  private val stack = mutable.ArrayBuffer[T]()

  def push(element: T): Unit = stack.append(element)
  def pop(): Option[T] = if (stack.nonEmpty) Some(stack.remove(stack.size - 1)) else None
  def peek: Option[T] = stack.lastOption
  def isEmpty: Boolean = stack.isEmpty
  def size: Int = stack.size
}

// Task 2: Simple Bank Account with Mutable State
class BankAccount(private var balance: Double) {
  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
  }

  def withdraw(amount: Double): Either[String, Double] = {
    if (amount > balance) Left("Insufficient funds")
    else {
      balance -= amount
      Right(balance)
    }
  }

  def getBalance: Double = balance
}

// Main application to run tests
object MutableCollectionsTest extends App {
  // Stack Test
  val stack = new MutableStack[Int]()
  stack.push(10)
  stack.push(20)
  stack.push(30)
  
  assert(stack.pop().contains(30))
  assert(stack.peek.contains(20))
  assert(stack.size == 2)
  println("Stack tests passed!")

  // Bank Account Test
  val account = new BankAccount(100.0)
  
  account.deposit(50.0)
  assert(account.getBalance == 150.0)

  assert(account.withdraw(30.0) == Right(120.0))
  assert(account.withdraw(200.0) == Left("Insufficient funds"))

  println("Bank account tests passed!")
}
