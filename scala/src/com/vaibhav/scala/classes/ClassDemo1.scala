package com.vaibhav.scala.classes

class Employee {
  // Scala will provide a default constructor, if class does not take arguments
  var name: String = null
}
object ClassDemo1 {
  def main(args: Array[String]) {

    var employee: Employee = new Employee
    println(employee.name)
    employee.name = "John"
    println(employee.name)

  }
}