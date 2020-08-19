package com.vaibhav.scala.classes

// Scala class declaration as constructor
class Employee4(var name: String) {
  var dept: String = null
  println("dept: " + dept)
}
object ClassDemo4 {
  def main(args: Array[String]) {
    var employee: Employee4 = new Employee4("abcd")
    println(employee.name)
    employee.name = "John"
    println(employee.name)
    println(employee.dept)
  }
}