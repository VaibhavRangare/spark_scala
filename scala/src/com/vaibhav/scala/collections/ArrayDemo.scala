package com.vaibhav.scala.collections

object ArrayDemo {
  def main(args: Array[String]) {
    var array = Array(1, 2, 3, "Hello")
    // Using foreach
    array.foreach(a => println(a))

    // Using for loop
    for (i <- array)
      println(i)
  }
}