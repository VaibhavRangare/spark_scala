package com.vaibhav.scala.basics

object Operators {

  def main(args: Array[String]) = {
    // var var_name: Type = literal
    var x: Int = 10
    // Operators are methods in scala
    // + operator is a method +(x:Int)
    // Call + method as follows
    // Every value/var in Scala is an object
    x = x.+(5)
    // We can remove .
    x = x + (5)
    // We can remove Parentheses
    x = x + 5
    println(x)
    // 25
    if (x.>(5)) {
      println("Greater than 5")
    }
    if (x > 5) {
      println("Greater than 5")
    }

  }
}