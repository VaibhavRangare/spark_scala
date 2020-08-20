package com.vaibhav.spark.df

import org.apache.spark.sql.SparkSession

object JsonDF {
  def main(args: Array[String]) {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sqlContext = spark.sqlContext
    val df = sqlContext.read.json("C:\\Resources\\scala\\employee.json")
    df.show()
  }
}