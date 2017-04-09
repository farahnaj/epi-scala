package com.epi.scala


class LevenshteinDistance(val string1: String, val string2: String) {

  val cache = collection.mutable.Map[(Int, Int), Int]()
  val s1 = Option(string1).getOrElse("")
  val s2 = Option(string2).getOrElse("")

  def execute() : Int = {
    levenshteinDistanceRecursive(s1, s2)
  }

  def levenshteinDistanceRecursive(A: String, B: String): Int = {

    val key = (A.length, B.length)

    (key._1, key._2) match {
      case (0, _) => {
        B.length
      }
      case (_, 0) => {
        A.length
      }
      case (aLen, bLen) if(cache.contains(key)) => {
        cache.get((aLen, bLen)).getOrElse(0)
      }
      case (aLen, bLen) if(A.charAt(aLen - 1) == B.charAt(bLen - 1)) => {
        levenshteinDistanceRecursive(A.substring(0, A.length - 1), B.substring(0, B.length - 1))
      }
      case (_, _) => {
        val case1 = levenshteinDistanceRecursive(A.substring(0, A.length - 1), B.substring(0, B.length))
        val case2 = levenshteinDistanceRecursive(A.substring(0, A.length), B.substring(0, B.length - 1))
        val case3 = levenshteinDistanceRecursive(A.substring(0, A.length - 1), B.substring(0, B.length - 1))

        val result = 1 + Math.min(Math.min(case1, case2), case3)
        cache.put(key, result)
        result
      }
    }
  }
}

object LevenshteinDistance extends App {
  override def main(args: Array[String]): Unit = {
    val string1 = "apple"
    val string2 = "amazon"
    val result = new LevenshteinDistance(string1, string2).execute()

    println(s"The Levenshtein Distance between $string1 and $string2 is $result")

  }
}
