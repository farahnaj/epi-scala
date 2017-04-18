val nums1 = List(1,3,3,6)
val nums2 = List(7,8,9)
//find(nums2)
//find(nums1)
betterFindMedian(null, null)
betterFindMedian(nums1, nums2)

def findMedian(nums1: List[Int], nums2: List[Int]): Option[Double] = {
  val numList: List[Int] = Option(nums1).getOrElse(List.empty) ++ Option(nums2).getOrElse(List.empty)
  if(numList.nonEmpty) {
    val array = numList.toArray
    val size = array.size
    (size % 2) match {
      case 0 => Some((array((size/2) - 1) + array(size/2))/ 2.0) //Even
      case 1 => Some(array(size/2)) //Odd
    }
  } else {
    None
  }
}

def betterFindMedian(nums1: List[Int], nums2: List[Int]): Option[Double] = {
  val numList: List[Int] = Option(nums1).getOrElse(List.empty) ++ Option(nums2).getOrElse(List.empty)
  println(numList)
  if(numList.nonEmpty) {
    val size = numList.size
    println(s"size: $size")
    val half = numList.size/2
    println(s"half: $half")
    val firstHalf = numList.take(half)
    val secondHalf = numList.drop(half)

    (size % 2) match {
      case 0 => Some((firstHalf.last + secondHalf.head)/2.0) //Even
      case 1 => Some(secondHalf.head) //Odd
    }
  } else {
    None
  }
}