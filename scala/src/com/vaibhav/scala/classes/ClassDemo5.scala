package com.vaibhav.scala.classes

// Scala class declaration as constructor
class Employee5(var name: String, var dept: String, var age: Int)
object ClassDemo5 {
  def main(args: Array[String]) {
    var employee: Employee5 = new Employee5("John", "CS", 20)
    println(employee.name)
    println(employee.dept)
    println(employee.age)
  }
}