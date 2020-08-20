package com.vaibhav.spark.df

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.functions.{ rand, randn }

object SeqDF {

  def df1 = {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sc = spark.sparkContext
    import spark.implicits._
    val seq1 = Seq(1, 2)
    val df1 = seq1.toDF()
    df1.show()
    println("Count: " + df1.count())
    println("Spark Version: " + sc.version)
    println("Scala Version: " + util.Properties.versionString)
  }

  def df2 = {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sc = spark.sparkContext
    import spark.implicits._
    val seq1 = Seq(1, 2)

    val someData = Seq(
      Row(8, "bat"),
      Row(64, "mouse"),
      Row(-27, "horse"))

    val someSchema = List(StructField("number", IntegerType, true), StructField("word", StringType, true))

    val someDF = spark.createDataFrame(spark.sparkContext.parallelize(someData), StructType(someSchema))
    println("type:" + someDF.getClass())
    someDF.show()
  }

  def df3 = {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sc = spark.sparkContext
    import spark.implicits._
    val seq1 = Seq(1, 2)
    val sqlcontext = spark.sqlContext
    val df = sqlcontext.createDataFrame(Seq((1, 10), (2, 11), (3, 12), (4, 13), (5, 14), (6, 15))).toDF("Key", "Value")
    df.show()
    val df1 = df.sample(withReplacement = false, fraction = .3, seed = 11L)
    val df2 = df.randomSplit(weights = Array(.5, .5))
    df2(0).show()
    df2(1).show()
  }

  def df4 = {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sc = spark.sparkContext
    import spark.implicits._
    val seq = Seq(
      (8, "bat"),
      (64, "mouse"),
      (-27, "horse"))
    val df = seq.toDF("number", "word")
    df.show()
    println(df.count())
  }

  def df5 = {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sc = spark.sparkContext
    val seq1 = Seq(1, 2)
    val sqlcontext = spark.sqlContext
    val df = sqlcontext.range(0, 10)
    val df1 = df.select("id").withColumn("Name", rand(10L))
    df.show()
    df1.show()
  }

  def df6 = {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val seq = Seq(("Castor", 24), ("Nick", 34), ("James", 55))
    val df = spark.createDataFrame(seq).toDF()
    df.show()
  }

  def df7 = {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val seq = Seq(("Castor", 24), ("Nick", 34), ("James", 55))
    val df = spark.createDataFrame(seq).toDF("Name", "Age")
    df.show()
  }

  def df8 = {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val seq = Seq(("Castor", 24), ("Nick", 34), ("James", 55))
    val df = spark.createDataFrame(seq)
    df.show()
  }

  def df9 = {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val seq = Seq(("Castor", 24), ("Nick", 34), ("James", 55))
    val rdd = spark.sparkContext.parallelize(seq)
    import spark.implicits._
    //val df = rdd.toDF()
    val df = rdd.toDF("Name", "Age")
    df.show()
  }

  def df10 = {
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sc = spark.sparkContext
    val seq = Seq(("Castor", 24), ("Nick", 34), ("James", 55))
    val sqlcontext = spark.sqlContext
    val rdd = spark.sparkContext.parallelize(seq)
    val schema = StructType(List(
      StructField("Name", StringType, true),
      StructField("Age", IntegerType, true)))
    val sqlContext = spark.sqlContext
    import spark.implicits._
    import sqlContext.implicits._
    val df = spark.createDataFrame(seq).toDF()
    //val df1 = df.select("id").withColumn("Name",rand(10L))
    df.show()
    //df1.show()
  }

  def main(args: Array[String]) {
    df2
  }
}