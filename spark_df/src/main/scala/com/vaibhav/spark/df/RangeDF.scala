package com.vaibhav.spark.df

import org.apache.spark.sql.SparkSession

object RangeDF {
  def main(args: Array[String]) {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sqlContext = spark.sqlContext
    val df = sqlContext.range(0, 10)
    df.show()
  }
}