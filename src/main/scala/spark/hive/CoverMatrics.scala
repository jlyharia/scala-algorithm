package spark.hive

import org.apache.spark.sql.DataFrame
import spark.spark.config.HiveSparkConfig

/**
  * Created by johnnyl on 1/25/16.
  */
object CoverMatrics extends HiveSparkConfig {
  //  https://github.com/apache/spark/blob/master/examples/src/main/scala/org/apache/spark/examples/sql/hive/HiveFromSpark.scala

  def main(args: Array[String]): Unit = {

    val file_path = "/Users/johnnyl/Desktop/company.orc";
    val df_company = sqlContext.read.format("orc").load(file_path);
    df_company.registerTempTable("company")
    df_company.printSchema()

    val df = sqlContext.sql("select domain, locations, linkedin from company where size(locations) >= 1 limit 10");
    df.show(3);

    saveToCsv(df)

  }

  def saveToCsv(df: DataFrame): Unit = {
    df.write.format("com.databricks.spark.csv")
      .mode("overwrite")
      .option("quote", "'")
      .save("/Users/johnnyl/Desktop/company_csv")
  }

}
