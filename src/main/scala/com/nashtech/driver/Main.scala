package com.nashtech.driver

import com.nashtech.dataframe.WordCountDataframe

object Main extends App {

  private val dataframe = WordCountDataframe

  private val orderByCount = dataframe.orderByCount

  private val getTopCountWord = dataframe.getTopCountWord

  orderByCount.show(false)

  println(getTopCountWord)

}
