package com.vaibhav.scala.companion

object ApplyDemo1 {
  var name: String = null
  var dept: String = null
  def apply(name: String) = {
    this.name = name
    println(this.name)
  }
  def apply(name: String, dept: String) = {
    this.name = name
    this.dept = dept
    println(this.name)
    println(this.dept)
  }
  def main(args: Array[String]) = {
    // Ways to call apply method
    ApplyDemo1.apply("John")
    ApplyDemo1("John")

    // Ways to call apply method
    ApplyDemo1.apply("John", "CS")
    ApplyDemo1("John", "CS")

  }
}