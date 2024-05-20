package com.nashtech.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object WordCount {
    val spark = SparkSession.builder()
      .appName("Word Count Example")
      .master("local[*]")
      .getOrCreate()

    private val sc = spark.sparkContext

    private val inputFilePath = "src/main/resources/sample.txt"

    private val textFileRDD = sc.textFile(inputFilePath)

    private val wordsRDD = textFileRDD.flatMap(line => line.split("\\W+"))

    private val wordCountRDD = wordsRDD.map(word => (word, 1))

    def wordCountsRDD: RDD[(String, Int)] = {
        wordCountRDD.reduceByKey((count1, count2) => count1 + count2)
    }

}

