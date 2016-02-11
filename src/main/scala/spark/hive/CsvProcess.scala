package spark.hive

import org.apache.spark.sql.DataFrame
import spark.miscellaneous.trial.dataframe._
import spark.spark.config.DefaultSparkConfig
//import org.apache.spark.SparkContext._
/**
  * Created by johnnyl on 1/25/16.
  */
object CsvProcess extends DefaultSparkConfig {

//  sqlContext.udf.register("uuid", uuid _)
  def main(args: Array[String]): Unit = {
    val df = sqlContext.read
      .format("com.databricks.spark.csv")
      .option("inferSchema", "true") // Automatically infer data types
      .option("quote", "'")
      .load("src/main/scala/resources/company.csv")
      .registerTempTable("company");

    sqlContext.sql("select * from company").show()
  }
}
