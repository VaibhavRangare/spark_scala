package com.vaibhav.scala.controlstmt

object MatchExample {
  def main(args: Array[String]) {
    var n = 3
    var v = n match {
      case 1 => "One"
      case 2 => "Two"
      case 3 => "Three"
      case _ => "Invalid"
    }
    println("value of 3 is :" + v)

    var p = 5
    var v1 = p match {
      case 1 | 3 | 5 | 7 => "odd"
      case 2 | 4 | 6 | 8 => "even"
      case default       => "other"
    }
    println("value of p is :" + v1)
  }
}