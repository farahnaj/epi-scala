package com.epi.scala.string

object Ransom extends App {

  def canIUseBagOfWords(bagOfWords: List[String], sentence: List[String]) = {
    val bagOfWordsMap = createMap(bagOfWords)
    val sentenceMap = createMap(sentence)
    val sentenceSet: Set[(String, Int)] = sentenceMap.toSet

    val result: Boolean = sentenceSet.forall(elem => bagOfWordsMap.get(elem._1) match {
      case None => false
      case Some(v) => v >= elem._2
    })

    result
  }

  def createMap(words: List[String]) = {
    val wordsMap = collection.mutable.HashMap[String, Int]()
    words.foreach(word => wordsMap.put(word, wordsMap.getOrElseUpdate(word, 0) + 1))
    wordsMap
  }

  override def main(args: Array[String]): Unit = {
    val bagOfWords = List("an", "apple", "apple")
    val sentence = List("an", "apple", "apple", "apple")
    println(s"$bagOfWords: $sentence => ${canIUseBagOfWords(bagOfWords, sentence)}")

    val bagOfWords2 = List("give", "me", "one", "grand", "today", "night", "today")
    val sentence2 = List("give", "one", "grand", "today")
    println(s"$bagOfWords2: $sentence2 => ${canIUseBagOfWords(bagOfWords2, sentence2)}")
  }

}
