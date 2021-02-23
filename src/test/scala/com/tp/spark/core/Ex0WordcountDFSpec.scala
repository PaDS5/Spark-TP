package com.tp.spark.core

import org.scalatest._

/**
 * Here are the tests to help you to implement the Ex0Wordcount
 */
class Ex0WordcountDFSpec extends FunSuite with Matchers {

  // this test is already green but see how we download the data in the loadData method
  test("number of data loaded") {
    val data = Ex0WordcountDF.loadData()
    data.count should be (809)
  }

  test("countWord should count the occurrences of each word"){
    val wordCounts = Ex0WordcountDF.wordcountDF()
    wordCounts.count should be (381)
    val wordCountSeq = wordCounts.collect.map(_.toSeq)
    wordCountSeq.filter(_.head.equals("the"))(0)(1) should be (38)
  }

  test("filterOnWordcount should keep the words which appear more than 4 times"){
    val wordCounts = Ex0WordcountDF.filterOnWordcountDF()
    wordCounts.count should be (26)
    val wordCountSeq = wordCounts.collect.map(_.toSeq)
    wordCountSeq.filter(_.head.equals("the"))(0)(1) should be (38)
    wordCountSeq.filter(_.head.equals("generally")).isEmpty should be (true)
  }

}
