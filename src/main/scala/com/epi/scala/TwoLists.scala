package com.epi.scala

case class TwoLists(list1: List[Int], list2: List[Int]) {

  val cache = new collection.mutable.HashSet[Int]()

  //Set with the order preserved
  val treeSet = new collection.mutable.TreeSet[Int]()

  def getIntersectionList(): List[Int] = {
    if(list1.size < list2.size){
      val set = list1.toSet
      list2.filter(set.contains(_))
//      list1.map(elem => cache.add(elem))
//      list2.filter(cache.contains(_)).sorted
    } else {
      list2.map(elem => cache.add(elem))
      list1.filter(cache.contains(_)).sorted
    }
  }

  def getUnion(): List[Int] = {
    list1.union(list2).foreach(treeSet.add(_))
    treeSet.toList
  }
}

object TwoLists extends App {
  override def main(args: Array[String]): Unit = {

    val list1 = List(1, 5, 15, 20, 30, 37)
    val list2 = List(2, 5, 13, 30, 32, 25, 37, 42)

    val intersection = TwoLists(list1, list2).getIntersectionList()
    //val union = TwoLists(list1, list2).getUnion()

    println(intersection)
//    Predef.require(intersection == List(3, 6, 7))
//    println(union)
//    Predef.require(union == List(1, 2, 3, 5, 6, 7, 8, 20))
  }
}
