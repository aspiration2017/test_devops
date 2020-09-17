import org.apache.spark.sql.SparkSession

object SimpleApp {
  def main(args: Array[String]) {
//    val logFile = "C:/Spark/spark-2.4.6-bin-hadoop2.7/README.md" // Should be some file on your system
    val logFile = "asd.txt"
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
    val logData = spark.read.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    spark.stop()
  }
}
