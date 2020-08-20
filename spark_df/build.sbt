scalaVersion := "2.12.3"

version := "1.0=SNAPSHAT"

libraryDependencies ++= Seq(
"org.apache.spark" %% "spark-core" % "3.0.0" % "provided",
"org.apache.spark" %% "spark-streaming" % "3.0.0" % "provided",
"org.apache.spark" %% "spark-sql" % "3.0.0"
)
