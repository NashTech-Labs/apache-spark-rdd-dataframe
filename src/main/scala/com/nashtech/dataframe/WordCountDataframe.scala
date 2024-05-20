package com.nashtech.dataframe

import com.nashtech.rdd.WordCount
import com.nashtech.rdd.WordCount.spark
import org.apache.spark.sql.functions.desc
import org.apache.spark.sql.{DataFrame, Dataset, Row}

object WordCountDataframe {

  private val wordCount = WordCount.wordCountsRDD

  import spark.implicits._

  private val df: DataFrame = wordCount.toDF("Word", "Count")

  def orderByCount: Dataset[Row] = {
    df.select("*").orderBy(desc("Count"))
  }

  def getTopCountWord: Row = {
    df.select("*").orderBy(desc("Count")).first()
  }


}
