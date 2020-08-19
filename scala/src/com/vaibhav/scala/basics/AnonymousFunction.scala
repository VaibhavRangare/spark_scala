package com.vaibhav.scala.basics

object AnonymousFunction {

  def firstFunction(x: Int) = {
    // Returning anonymous function
    (y: Int) => x + y
  }
  // Rewriting above function
  def otherFunction(x: Int) = (y: Int) => x + y

  def main(args: Array[String]) = {

    // firstFunction is returning anonymous function which takses int as argument
    var x = firstFunction(5)
    // x is not a function which takes int argument
    println(x(4))

    // Another way to call the fucntion
    var y = firstFunction(5)(12)
    println(y)

    x = otherFunction(5)
    println(x(4))

    // Another way to call the fucntion
    y = otherFunction(5)(12)
    println(y)

  }

}