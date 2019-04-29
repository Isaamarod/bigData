import org.apache.spark.{SparkContext, SparkConf}
object wordCount {

    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("Simple Application").setMaster("local")
          val sc = new SparkContext(conf)
          val data = sc.textFile("/home/isa/Escritorio/spark-2.4.1-bin-hadoop2.7/README.md").cache()
          val wcSpark = data.flatMap(l => l.split(" ")).filter(x => x == "Spark").map(word =>
          (word,1)).reduceByKey(_ + _)
          wcSpark.foreach(println)
          val wc = data.flatMap(_.split(" ")).map((_,1)).reduceByKey(_ + _)
          wc.foreach(println)

          }
          }