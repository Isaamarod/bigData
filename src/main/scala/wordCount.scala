import org.apache.spark.{SparkContext, SparkConf}
object wordCount {

    def main(args: Array[String]): Unit = {
        val conf = new SparkConf().setAppName("Simple Application").setMaster("local")
          val sc = new SparkContext(conf)
          val data = sc.textFile("./src/main/resources/shakespeare.txt").cache()
          val wcSpark = data.flatMap(l => l.split(" ")).map(word =>(word,1)).reduceByKey(_ + _)
          wcSpark.foreach(println)
          val wc = data.flatMap(_.split(" ")).map((_,1)).reduceByKey(_ + _)
          wc.foreach(println)
          wc.saveAsTextFile(path= "./src/main/tmp/shakespeareWordCountOutput_3")


    }
          }