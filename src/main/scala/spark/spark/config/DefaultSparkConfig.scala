package spark.spark.config

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by johnnyl on 1/25/16.
  */
class DefaultSparkConfig {
  val conf = new SparkConf().setAppName("spark_local").setMaster("local[4]")
  val sc = new SparkContext(conf)
  val sqlContext = new org.apache.spark.sql.SQLContext(sc)
}
