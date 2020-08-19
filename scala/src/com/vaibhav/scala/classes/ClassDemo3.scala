package com.vaibhav.scala.classes

// Scala class declaration without class body
// Scala class declaration as constructor
class Employee3(var name: String)
object ClassDemo3 {
  def main(args: Array[String]) {
    var employee: Employee3 = new Employee3("abcd")
    println(employee.name)
    employee.name = "John"
    println(employee.name)
  }
}