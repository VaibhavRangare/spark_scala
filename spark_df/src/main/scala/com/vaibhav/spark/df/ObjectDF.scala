package com.vaibhav.spark.df

import org.apache.spark.sql.SparkSession

case class Employee(name: String, age: Int)
object ObjectDF {
  def main(args: Array[String]) {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sc = spark.sparkContext
    val sqlContext = spark.sqlContext
    import sqlContext.implicits._
    //import spark.implicits._
    val info = List(("Castor", 24), ("Nick", 34), ("James", 55))
    val infoRDD = sc.parallelize(info)
    val employee = infoRDD.map(r => Employee(r._1, r._2)).toDF()
    employee.show()
    import spark.implicits._
    employee.registerTempTable("employee")
    val subDF = sqlContext.sql("select * from employee where age > 30")
    subDF.show()
  }
  
}