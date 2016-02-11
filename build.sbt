name := """hello-scala"""

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"
// spark
libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.6.0"
libraryDependencies += "com.databricks" %% "spark-csv" % "1.3.0"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "1.6.0"

// scala jdbc
libraryDependencies += "org.scalikejdbc" %% "scalikejdbc-core" % "2.3.4"
libraryDependencies += "org.scalikejdbc" %% "scalikejdbc-config" % "2.3.4"

//postgres
libraryDependencies += "org.postgresql" % "postgresql" % "9.4.1207"

fork in run := true


