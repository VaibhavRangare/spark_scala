package com.vaibhav.scala.classes

class Employee2 {
  // Scala will provide a default constructor, if class does not take arguments
  var name: String = null
  // Create constructor
  def this(name: String) = {
    this()
    this.name = name
  }
}
object ClassDemo2 {
  def main(args: Array[String]) {

    var employee: Employee2 = new Employee2
    println(employee.name)
    employee.name = "John"
    println(employee.name)

    /*
    var employee: Employee2 = new Employee2("xyz")
    println(employee.name)
    employee.name = "John"
    println(employee.name)
    */

  }
}