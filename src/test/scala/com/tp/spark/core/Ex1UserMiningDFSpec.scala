package com.tp.spark.core

import org.scalatest.{FunSuite, Matchers}

/**
 * Here are the tests to help you to implement the Ex1UserMiningDF
 */
class Ex1UserMiningDFSpec extends FunSuite with Matchers {

  test("should count the number of couple (user, tweets)") {
    val tweets = Ex1UserMiningDF.tweetsByUserDF()
    tweets.count should be (5967)
  }

  test("tweetByUserNumber should count the number of tweets by user"){
    val tweetsByUser = Ex1UserMiningDF.tweetByUserNumberDF()
    tweetsByUser.count should be (5967)
    tweetsByUser.collect.map{r => (r.apply(0), r.apply(1))} should contain ("Dell Feddi", 29L)
  }

  test("should return the top ten twitterers"){
    val top10 = Ex1UserMiningDF.topTenTwitterersDF()
    top10.count() should be (10)
    top10.collect.map{r => (r.apply(0), r.apply(1))} should contain ("williampriceking",46L)
  }

}
