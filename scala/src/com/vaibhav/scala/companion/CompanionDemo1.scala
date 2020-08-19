package com.vaibhav.scala.companion

// Claas and Object Employee1 are companion
class Employee1(var name: String, var dept: String)

object Employee1 {

  // Create object using apply methd
  def apply(name: String, dept: String) = new Employee1(name, dept)

  def main(args: Array[String]) = {
    // Call Object's apply method to create class instance
    var employee1: Employee1 = Employee1.apply("John", "CS")
    var employee2: Employee1 = Employee1("Castor", "ET")
    println(employee1.name + ", " + employee1.dept)
    println(employee2.name + ", " + employee2.dept)

  }
}