package com.vaibhav.spark.df

import org.apache.spark.sql.SparkSession

case class Student(name: String, age: Int)
object Statistics {
  def statistics1 = {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sc = spark.sparkContext
    val sqlcontext = spark.sqlContext
    import sqlcontext.implicits._
    
    val info = List(("mike", 24), ("joe", 34), ("jack", 55))
    val infoRDD = sc.parallelize(info)
    val student = infoRDD.map(r => Student(r._1, r._2)).toDF()
    student.show()
    student.registerTempTable("student")
    val subDF = sqlcontext.sql("select age from student where age > 30")
    val min_val = subDF.rdd.map(a => a.getInt(0)).min()
    val max_val = subDF.rdd.map(a => a.getInt(0)).max()
    val mean_val = subDF.rdd.map(a => a.getInt(0)).mean()
    val sum_val = subDF.rdd.map(a => a.getInt(0)).sum()
    val sd_val = subDF.rdd.map(a => a.getInt(0)).stdev()
    val count_val = subDF.rdd.map(a => a.getInt(0)).count()
    val first_val = subDF.rdd.map(a => a.getInt(0)).first()
    val max1_val = subDF.rdd.map(a => a.getInt(0)).reduce((a, b) => Math.min(a, b))
    println("min_val: " + min_val)
    println("max_val: " + max_val)
    println("mean_val: " + mean_val)
    println("sum_val: " + sum_val)
    println("sd_val: " + sd_val)
    println("count_val: " + count_val)
    println("first_val: " + first_val)
    println("max1_val: " + max1_val)
    //subDF.rdd.map(a => a.getInt(0)).foreach(a => println(a * 10))
  }
  def main(args: Array[String]) {
    statistics1
  }
}