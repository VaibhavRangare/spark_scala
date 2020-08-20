package com.vaibhav.spark.df

import org.apache.spark.sql.SparkSession

object GetSqlContext {
  def main(args: Array[String]) {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sc = spark.sparkContext
    val sqlContext = spark.sqlContext
    import sqlContext.implicits._
    println("Spark Context: "+sqlContext)
    println("Spark Version: "+sc.version)
    println("Scala Version: "+util.Properties.versionString)
    
  }
}