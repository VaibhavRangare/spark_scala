package com.vaibhav.scala.basics

object Methods {

  // def MethodName(var: Type) = { Method }
  def objectMethod(x: Int) = {
    println(x)
  }

  // Method without any parameter
  // We can remove Parentheses at the time of declaration and call
  def objectMethod = {
    println("objectMethod")
  }
  def otherObjectMethod(x: Int, y: Int) = {
    println(x + ", " + y)
  }

  // Method returning value
  // def MethodName(var: Type):ReturnType = { Method }
  def objectMethodWithReturn(x: Int): Int = {
    println(x)
    // return is optional
    // return x
    // Last statement is the return type
    x
  }

  def main(args: Array[String]) = {
    // var var_name: Type = literal
    var x: Int = 10
    var y: Int = 20
    // Need Parentheses to call this method
    // Different ways to call a function
    objectMethod(x)
    otherObjectMethod(x, y)
    y = objectMethodWithReturn(x)
    println(objectMethodWithReturn(x))
    objectMethod

  }
}