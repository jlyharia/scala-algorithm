package spark.postgresql

import java.util.Properties

import spark.spark.config.DefaultSparkConfig

import java.sql.DriverManager;

/**
  * Created by johnnyl on 1/25/16.
  */
object PostgresJDBC {

  val Postgres_url = "jdbc:postgresql://localhost:5432/johnnyl";
  val USER = "johnnyl";
  val PW = "";

  def main(args: Array[String]): Unit = {
    Class.forName("org.postgresql.Driver");
    val con = DriverManager.getConnection(Postgres_url, USER, PW);


    val rs = con.createStatement().executeQuery("select * from locs");

    while(rs.next()){

      println(rs.getObject("locations"));

    }


    con.close();
    //    val props = new Properties();
    //    props.setProperty("user", "johnnyl");
    //    props.setProperty("password", "");
    //    val df = sqlContext.read.jdbc("jdbc:postgresql://localhost:5432/johnnyl", "locs", props)
    //    df.printSchema()
    //    df.registerTempTable("locs")

    //    sqlContext.sql("select * from locs").show()


  }

}
class location{
    def street : String;
}