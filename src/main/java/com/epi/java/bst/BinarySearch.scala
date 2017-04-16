package com.epi.java.bst

case class BinarySearch(val sortedList: List[Int]) {

  def containsTarget(value: Int): Boolean = {
    search(lowIndex = 0, highIndex = sortedList.size - 1, target = value).isDefined
  }

  private def search(lowIndex: Int, highIndex: Int, target: Int): Option[Int] = {
    //The indexes meet
    if(lowIndex > highIndex ) {
      None
    } else {
      val midIndex = lowIndex + (highIndex - lowIndex)/2
      sortedList(midIndex) match {
        case midValue if(target == midValue) => Some(midIndex)
        case midValue if(target <= midValue) => search(lowIndex, midIndex - 1, target)
        case _ => search(midIndex + 1, highIndex, target)
      }
    }
  }
}

object BinarySearch extends App {
  override def main(args: Array[String]): Unit = {

    val sortedList = List(5,6,7)
    val target = 4
    val bs = new BinarySearch(sortedList)
    println(s"list contains target? ${bs.containsTarget(target)}")
  }
}
