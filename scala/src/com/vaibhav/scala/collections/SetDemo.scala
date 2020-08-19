package com.vaibhav.scala.collections

object SetDemo {
  def main(args: Array[String]) {
    var set = Set(1, 2, 3, 3, "Hello")
    // Using foreach
    set.foreach(a => println(a))

    // Using for loop
    for (i <- set)
      println(i)
  }
}