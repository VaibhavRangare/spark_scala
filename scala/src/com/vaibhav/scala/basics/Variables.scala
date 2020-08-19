package com.vaibhav.scala.basics

object Variables {
  def main(args: Array[String]) = {
    // var var_name: Type = literal
    var x: Int = 10
    println(x)
    val y: Int = 20
    println(y)
    val s: String = "Hello Scala"
    println(s)
    x = x.+(5)
    x = x + (5)
    x = x + 5
    println(x)
  }
}