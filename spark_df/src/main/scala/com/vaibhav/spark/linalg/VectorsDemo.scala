package com.vaibhav.spark.linalg

import org.apache.spark.mllib.linalg.{ Vectors, Vector, SparseVector }
import com.google.gson.Gson
import org.apache.spark.mllib.linalg.DenseVector
import org.apache.spark.mllib.regression.LabeledPoint

case class Item(name: Double, age: Double)

object VectorsDemo {

  def array = {
    val arr = Array(1, 2, 3)
    println(arr.getClass)
    for (item <- arr)
      println(item)
  }

  def denseVector = {
    val vector1: Vector = Vectors.dense(1, 2, 3)
    println(vector1.getClass)
    println(vector1)

    val arr = Array(1.1, 2.2, 3.3)
    val vector2 = new DenseVector(arr)
    println(vector2)
  }

  def labeledPoint = {
    val lp = LabeledPoint(1.0, Vectors.dense(10.0, 0.0, 5.0))
    println("lp:" + lp)
  }

  def sparceVector = {
    val index = Array(1, 2, 3)
    val arr = Array(1.1, 2.2, 3.3)
    val vector1 = new SparseVector(3, index, arr)
    println(vector1)
  }

  def main(args: Array[String]) {
    labeledPoint

  }
}