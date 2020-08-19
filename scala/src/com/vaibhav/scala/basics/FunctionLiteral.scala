package com.vaibhav.scala.basics

object FunctionLiteral {

  def intCompare(x: Int, callback: (Int) => Boolean) = callback(x)
  def main(args: Array[String]) = {
    // Functional literal
    var x = (p: Int) => p + 5: Int
    println(x(5))

    // Custom Functional literal
    var y: Int = 5
    println(intCompare(y, (p => p > 3)))

  }
}