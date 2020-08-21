package com.vaibhav.spark.ml.regression

import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession;
import org.apache.spark.ml.linalg.SparseVector

@SerialVersionUID(100L)
case class DemoItems(label: Double, features: SparseVector) extends Serializable

object LogisticRegressionDemo {
  def main(args: Array[String]) {
    val spark = SparkSession.builder().appName("Vaibhav App").master("local").getOrCreate();
    val sc = spark.sparkContext
    val training = spark.read.format("libsvm").load("C:\\Resources\\scala\\sample_libsvm_data.txt")
    val sqlContext = spark.sqlContext
    training.show()
    val rdd1 = training.rdd
    println(rdd1.count())
    rdd1.collect().foreach(a => println(a.getClass))
    import spark.implicits._
    val items = rdd1.map(r => DemoItems(r.getDouble(0), r.getAs(1): SparseVector)).toDF()
    items.show()
    val lr = new LogisticRegression().setMaxIter(10).setRegParam(0.3).setElasticNetParam(0.8)
    val trainTest = items.randomSplit(Array(0.5, 0.5))
    val trainingDF = trainTest(0)
    val testDF = trainTest(1)
    testDF.show()
    val lrModel = lr.fit(items)
    println(s"Coefficients: \n${lrModel.coefficientMatrix}")
    println(s"Intercepts: \n${lrModel.interceptVector}")
    val fullPredictions = lrModel.transform(items).cache()
    fullPredictions.show()
  }
}