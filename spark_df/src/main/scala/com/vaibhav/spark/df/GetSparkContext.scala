package com.vaibhav.spark.df

import org.apache.spark.sql.SparkSession

object GetSparkContext {
  def main(args: Array[String]) {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sc = spark.sparkContext
    import spark.implicits._
    println("Spark Context: " + sc)
    println("Spark Version: " + sc.version)
    println("Scala Version: " + util.Properties.versionString)

  }
}