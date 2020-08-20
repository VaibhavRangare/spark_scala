package com.vaibhav.spark.df
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.StringType
import org.apache.spark.sql.functions.{rand, randn}
import org.apache.spark.sql.Column


case class Person(name: String, age: Int)

object ScalaDF {

  def showDataFrame1 = {
    val conf = new SparkConf().setAppName("Samples").setMaster("local")
    val sc = new SparkContext(conf)
    val seq1 = Seq(1, 2)
    val spark = SparkSession.builder().getOrCreate();
    import spark.implicits._
    val df1 = seq1.toDF()
    df1.show()
    println(df1.count())
    println("Spark Version: "+sc.version)
    println("Scala Version: "+util.Properties.versionString)
    //println(df1.summary("Hello"))
  }
  
  def showDataFrame2 = {
    val conf = new SparkConf().setAppName("Samples").setMaster("local")
    val sc = new SparkContext(conf)
    val spark = SparkSession.builder().getOrCreate();
    val training = spark.read.format("libsvm").load("C:\\Resources\\scala\\sample_libsvm_data.txt")
    training.show()
  }
  def showDataFrame3 = {
    val conf = new SparkConf().setAppName("Samples").setMaster("local")
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sqlContext = spark.sqlContext
    //val sc = new SparkContext(conf)
    //val sqlcontext = new SQLContext(sc)
    val df = sqlContext.range(0, 10)
    df.show()
  }
  def showDataFrame4 = {
    val conf = new SparkConf().setAppName("Samples").setMaster("local")
    val sc = new SparkContext(conf)
    //val sqlcontext = new org.apache.spark.sql.SQLContext(sc)
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sqlContext = spark.sqlContext
    val df = sqlContext.read.json("C:\\Resources\\scala\\employee.json")
    // Below functions are working
    //df.show()
    //df.select("name").show()
    //println("Printing schema")
    //df.printSchema()
    //df.filter(df("age") > 23).show()
    //df.groupBy("age").count().show()
    df.filter(df("age") > 23).distinct().show()
  }

  def showDataFrame5 = {
    val conf = new SparkConf().setAppName("Samples").setMaster("local")
    val sc = new SparkContext(conf)
    
    //val sqlcontext = new org.apache.spark.sql.SQLContext(sc)
    //import sqlcontext.implicits._
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sqlContext = spark.sqlContext
    import sqlContext.implicits._
    //import spark.implicits._
    val info = List(("mike", 24), ("joe", 34), ("jack", 55))
    val infoRDD = sc.parallelize(info)
    val people = infoRDD.map(r => Person(r._1, r._2)).toDF()
    //val people = infoRDD.map(r => Person(r._1, r._2))
    import spark.implicits._
    people.registerTempTable("people")
    //people.registerTempTabl
    //people.r
    val subDF = sqlContext.sql("select * from people where age > 30")
    subDF.show()
  }
  def showDataFrame6 = {
    val conf = new SparkConf().setAppName("Samples").setMaster("local")
    val sc = new SparkContext(conf)
    val seq1 = Seq(1, 2)
    val spark = SparkSession.builder().getOrCreate();
    import spark.implicits._
    val someData = Seq(
      Row(8, "bat"),
      Row(64, "mouse"),
      Row(-27, "horse"))

    val someSchema = List(
      StructField("number", IntegerType, true),
      StructField("word", StringType, true))

    val someDF = spark.createDataFrame(
      spark.sparkContext.parallelize(someData),
      StructType(someSchema))
    someDF.show()
  }
   def showDataFrame7 = {
    val conf = new SparkConf().setAppName("Samples").setMaster("local")
    val sc = new SparkContext(conf)
    val seq1 = Seq(1, 2)
    //val spark = SparkSession.builder().getOrCreate();
    //val sqlcontext = new org.apache.spark.sql.SQLContext(sc)
    //import sqlcontext.implicits._
    
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sqlcontext = spark.sqlContext
    
    val df = sqlcontext.createDataFrame(Seq((1,10),(2,11),(3,12),(4,13),(5,14),(6,15))).toDF("Key","Value")
    
    df.show()
    val df1 = df.sample(withReplacement=false, fraction=.3, seed=11L)
    val df2 = df.randomSplit(weights=Array(.5,.5))
    //val sam = df.sample(.5)
    //df1.show()
    df2(0).show()
    df2(1).show()
  }
  def showDataFrame8 = {
    val conf = new SparkConf().setAppName("Samples").setMaster("local")
    val sc = new SparkContext(conf)
    val seq1 = Seq(
      (8, "bat"),
      (64, "mouse"),
      (-27, "horse"))
    val spark = SparkSession.builder().getOrCreate();
    import spark.implicits._
    val df1 = seq1.toDF("number", "word")
    df1.show()
    println(df1.count())
    //println(df1.summary("Hello"))
  }
  def showDataFrame9 = {
    val conf = new SparkConf().setAppName("Samples").setMaster("local")
    val sc = new SparkContext(conf)
    val seq1 = Seq(1, 2)
    //val spark = SparkSession.builder().getOrCreate();
    //val sqlcontext = new org.apache.spark.sql.SQLContext(sc)
    
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sqlcontext = spark.sqlContext
    
    val df = sqlcontext.range(0,10)
    val df1 = df.select("id").withColumn("Name",rand(10L))
    
    df.show()
    df1.show()
    
   // df1.show()
   
  }
  def showDataFrame10 = {
    val conf = new SparkConf().setAppName("Samples").setMaster("local")
    val sc = new SparkContext(conf)
    
    //val spark = SparkSession.builder().getOrCreate();
    //val sqlcontext = new org.apache.spark.sql.SQLContext(sc)
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sqlContext = spark.sqlContext
    
    val seq1 = Seq(
      (8, Double.NaN),
      (64, 10.0),
      (-27, Double.NaN))
    import spark.implicits._
    val df1 = seq1.toDF("number", "word")
    df1.show()
    val df2 = df1.drop("word")
    df1.show()
    df2.show()
    val df3 = df1.na.drop(minNonNulls=1)
    df3.show()
    val df4 = df1.na.drop("any",Array("number", "word"))
    df4.show()
    val df5 = df1.na.fill(0.0)
    df5.show()
    
    val df6 = df1.na.replace("word", Map(Double.NaN-> 0.0))
    df6.show()
   
  }
  def statistics1 = {
    val conf = new SparkConf().setAppName("Samples").setMaster("local")
    val sc = new SparkContext(conf)
    //val sqlcontext = new org.apache.spark.sql.SQLContext(sc)
    //import sqlcontext.implicits._
    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sqlcontext = spark.sqlContext
    import sqlcontext.implicits._
    
    val info = List(("mike", 24), ("joe", 34), ("jack", 55))
    val infoRDD = sc.parallelize(info)
    val people = infoRDD.map(r => Person(r._1, r._2)).toDF()
    people.registerTempTable("people")
    val subDF = sqlcontext.sql("select age from people where age > 30")
    //subDF.show()
    val min_val = subDF.rdd.map(a => a.getInt(0)).min()
    val max_val = subDF.rdd.map(a => a.getInt(0)).max()
    val mean_val = subDF.rdd.map(a => a.getInt(0)).mean()
    val sum_val = subDF.rdd.map(a => a.getInt(0)).sum()
    val sd_val = subDF.rdd.map(a => a.getInt(0)).stdev()
    val count_val = subDF.rdd.map(a => a.getInt(0)).count()
    val first_val = subDF.rdd.map(a => a.getInt(0)).first()
    val max1_val = subDF.rdd.map(a => a.getInt(0)).reduce((a, b) => Math.min(a, b))
    println("min_val" + min_val + "\n")
    println("max_val" + max_val + "\n")
    println("mean_val" + mean_val + "\n")
    println("sum_val" + sum_val + "\n")
    println("sd_val" + sd_val + "\n")
    println("count_val" + count_val + "\n")
    println("first_val" + first_val + "\n")
    println("max1_val" + max1_val + "\n")
    subDF.rdd.map(a => a.getInt(0)).foreach(a => println(a * 10))
  }
  def statistics2 = {
    val conf = new SparkConf().setAppName("Samples").setMaster("local")
    val sc = new SparkContext(conf)
    //val sqlcontext = new org.apache.spark.sql.SQLContext(sc)
    //import sqlcontext.implicits._

    val spark = SparkSession.builder().appName("Vaibhav Appp").master("local").getOrCreate();
    val sqlcontext = spark.sqlContext
    import sqlcontext.implicits._
    
    val seq1 = Seq(1, 2, 4, 8, 10, 3)
    //val spark = SparkSession.builder().getOrCreate();

    val df = seq1.toDF()
    df.show()
    val min_val = df.rdd.map(a => a.getInt(0)).min()
    val max_val = df.rdd.map(a => a.getInt(0)).max()
    val mean_val = df.rdd.map(a => a.getInt(0)).mean()
    val sum_val = df.rdd.map(a => a.getInt(0)).sum()
    val sd_val = df.rdd.map(a => a.getInt(0)).stdev()
    val count_val = df.rdd.map(a => a.getInt(0)).count()
    val first_val = df.rdd.map(a => a.getInt(0)).first()
    val max1_val = df.rdd.map(a => a.getInt(0)).reduce((a, b) => Math.min(a, b)) // not working
    println("min_val" + min_val + "\n")
    println("max_val" + max_val + "\n")
    println("mean_val" + mean_val + "\n")
    println("sum_val" + sum_val + "\n")
    println("sd_val" + sd_val + "\n")
    println("count_val" + count_val + "\n")
    println("first_val" + first_val + "\n")
    println("max1_val" + max1_val + "\n")
    df.rdd.map(a => a.getInt(0)).foreach(a => println(a * 10))
    df.collect().foreach(a => print(a + ", "))
  }
  
  def main(args: Array[String]) {

    //val conf = new SparkConf().setAppName("Samples").setMaster("local")
    //val sc = new SparkContext(conf)
    //System.setProperty("hadoop.home.dir", "C:\\Resources\\scala");

    //showDataFrame1
    //showDataFrame2
    //showDataFrame3
    //showDataFrame4
    //showDataFrame5
    //showDataFrame6
    //showDataFrame7
    //showDataFrame8
    showDataFrame9
    //showDataFrame10
    //statistics1
    //statistics2
  }
}