package com.vaibhav.scala.classes

// Scala class declaration as primary constructor
class Employee6(var name: String, var dept: String, var age: Int) {

  // Auxiliary constructor
  def this(name: String, dept: String) {
    this(name, dept, 20)
  }
  def this(name: String) {
    this(name, "CS", 20)
  }
  def this() {
    this("John", "CS", 20)
  }
}
object ClassDemo6 {
  def main(args: Array[String]) {
    var employee: Employee6 = new Employee6()
    println(employee.name)
    println(employee.dept)
    println(employee.age)
  }
}