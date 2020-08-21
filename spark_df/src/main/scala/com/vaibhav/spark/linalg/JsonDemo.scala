package com.vaibhav.spark.linalg


import com.google.gson.Gson

case class Employee(name: String, age: Int)

object jSonDemo {

  def createJsonStringFromObject = {
    val p = Employee("Castor", 20)
    val gson = new Gson
    val jsonString = gson.toJson(p)
    println(jsonString)
  }
  def createObjectFromJsonString = {
    val gson = new Gson
    val jsonString = """
      {
      "name": "John",
      "age": 22
      }
      """
    val emloyee = gson.fromJson(jsonString, classOf[Employee])
    println(emloyee)
  }
  def main(args: Array[String]) {
    createJsonStringFromObject
  }
}