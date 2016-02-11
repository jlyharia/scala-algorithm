package spark.miscellaneous.trial

import org.apache.spark.sql.functions._
import java.util.UUID

import spark.spark.config.DefaultSparkConfig

/**
  * Created by johnnyl on 1/25/16.
  */
object dataframe extends DefaultSparkConfig {
  //  http://www.nodalpoint.com/spark-data-frames-from-csv-files-handling-headers-column-types/
  def randomUUID(): String = {
    UUID.randomUUID.toString
  };

  def main(args: Array[String]): Unit = {
    //    val data = Array(1, 2, 3, 4, 5)
    //    val distData = sc.parallelize(data)
    //    distData.foreach(println)

    val df = sqlContext.read
      .format("com.databricks.spark.csv")
      .option("header", "true") // Use first line of all files as header
      .option("inferSchema", "true") // Automatically infer data types
      .load("src/main/scala/resources/location.csv")
      .registerTempTable("t");

    def locFilter(str: String): String = {
      str.replace("[", "").replace("]", "")
    }
    sqlContext.udf.register("locFilter", locFilter _);
    sqlContext.sql("select locFilter(location) from t").show()


    //    df.wi.select("email")
    //      .map(r => if (r == null) "xxx" else r)
    //      .collect()
    //      .foreach(println)
    //    val uid = UUID.randomUUID;

  }

}
