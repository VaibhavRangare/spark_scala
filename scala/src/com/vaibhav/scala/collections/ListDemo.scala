package com.vaibhav.scala.collections

object ListDemo {
  def main(args: Array[String]) {
    var list = List(1, 2, 3, 4, "hello")
    println(list.getClass())
    // Using foreach
    list.foreach(println)
    list.foreach((a) => println(a))

    // Using for loop
    for (i <- list)
      println(i)
  }
}