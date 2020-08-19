package com.vaibhav.scala.companion

class Employee(var name: String, var dept: String) {
  var age: Int = 0
  // Class apply method
  def apply(age: Int) = {
    this.age = age
  }
}

object ApplyDemo2 {

  def main(args: Array[String]) = {
    var employee: Employee = new Employee("John", "CS")
    println("Age:" + employee.age)
    employee(27)
    println("Age:" + employee.age)
  }
}