package com.vaibhav.spark.linalg

import org.apache.spark.mllib.linalg.{ Matrix, Matrices }
import com.google.gson.Gson

object MatricesDemo {

  def denseMatrix = {
    val denseMatrix = Matrices.dense(3, 2, Array(1, 2, 3, 4, 5, 6))
    println(denseMatrix)
  }

  def sparceMatrix = {
    val sparceMatrix = Matrices.sparse(5, 4, Array(0, 0, 1, 2, 2), Array(1, 3), Array(34, 55))
    println(sparceMatrix)
  }

  def main(args: Array[String]) {
    sparceMatrix
  }
}