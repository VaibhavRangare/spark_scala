package com.vaibhav.spark.ml.regression

import org.apache.spark.sql.SparkSession;
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.ml.linalg.SparseVector

@SerialVersionUID(1001L)
case class DemoItems1(label: Double, features: SparseVector) extends Serializable

object LinearRegressionDemo {
  def main(args: Array[String]) {
    val spark = SparkSession.builder().appName("Vaibhav App").master("local").getOrCreate();
    val sc = spark.sparkContext
    import spark.implicits._
    val training = spark.read.format("libsvm").load("C:\\Resources\\scala\\sample_linear_regression_data.txt")
    val sqlContext = spark.sqlContext
    training.show()
    val rdd = training.rdd
    println(rdd.count())
    import spark.implicits._
    @transient
    val items = rdd.map(r => DemoItems1(r.getDouble(0), r.getAs(1): SparseVector)).toDF()
    items.show()
    val trainTest = items.randomSplit(Array(0.5, 0.5))
    val trainingDF = trainTest(0)
    val testDF = trainTest(1)
    testDF.show()
    val lr = new LinearRegression().setMaxIter(10).setRegParam(0.3).setElasticNetParam(0.8)
    val lrModel = lr.fit(items)
    val fullPredictions = lrModel.transform(items).cache()
    fullPredictions.show()
  }
}