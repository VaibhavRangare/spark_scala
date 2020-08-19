package com.vaibhav.scala.companion

// Claas and Object Employee1 are companion
class Employee2(var name: String, var dept: String) {
  def instanceMethod1OfClass = {
    println("instanceMethod1OfClass")
  }

  def instanceMethod2OfClass(item: String) = {
    println("instanceMethod2OfClass: " + item)
  }
}

object Employee2 {
  def staticMethod1OfObject() {
    println("staticMethod1OfObject")
  }
  def staticMethod2OfObject(item: String) {
    println("staticMethod2OfObject: " + item)
  }
  // Create object using apply methd
  def apply(name: String, dept: String) = new Employee2(name, dept)

  def main(args: Array[String]) = {
    // Call Object's apply method to create class instance
    var employee1: Employee2 = Employee2.apply("John", "CS")
    var employee2: Employee2 = Employee2("Castor", "ET")
    println(employee1.name + ", " + employee1.dept)
    println(employee2.name + ", " + employee2.dept)
    employee1.instanceMethod1OfClass
    employee1.instanceMethod2OfClass("Sample parameter")
    staticMethod1OfObject
    staticMethod2OfObject("param")

  }
}