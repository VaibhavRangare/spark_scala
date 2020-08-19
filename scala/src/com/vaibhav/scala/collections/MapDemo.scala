package com.vaibhav.scala.collections

object MapDemo {
  def main(args: Array[String]) {
    var map = Map(1 -> "One", 1 -> "Four", 2 -> "Two", 3 -> "Three")
    println(map)
    // Using foreach
    map.foreach(a => println(a))

    // Using for loop
    for (i <- map)
      println(i)
  }
}