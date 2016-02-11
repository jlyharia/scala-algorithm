package spark.postgresql


import spark.spark.config.DefaultSparkConfig

import java.util.Properties


/**
  * Created by johnnyl on 1/25/16.
  */
object PostgresApp extends DefaultSparkConfig {

  def main(args: Array[String]): Unit = {

    val props = new Properties();
    props.setProperty("user", "johnnyl");
    props.setProperty("password", "");
    val df = sqlContext.read.jdbc("jdbc:postgresql://localhost:5432/johnnyl", "locs", props)
    df.printSchema()
//    df.registerTempTable("locs")

//    sqlContext.sql("select * from locs").show()


  }

}
