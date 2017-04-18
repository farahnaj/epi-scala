import scala.collection.mutable

//val s = "pwxwkey"
//val s = "pwxwkew"
//val s = "pwwkezw"
val s = "bbbbbbbbbb"
//val s = "abcabcbb"
//val s = null

getLongestSeq(s)

def getLongestSeq(s: String): String = {
  val map = mutable.SortedMap[Int, String]() (Ordering[Int].reverse)
  val set = mutable.Set[Char]()
  var sb = new mutable.StringBuilder()
  Option(s).getOrElse("").foreach(c => {
    if(!set.contains(c: Char)) {
      set.add(c)
      sb.append(c)
    } else {
      map.put(sb.length, sb.toString())
      val lastElement = sb.charAt(sb.length - 1)
      sb = new mutable.StringBuilder()
      if(!lastElement.equals(c)) {
        sb.append(lastElement)
        sb.append(c)
      } else {
        sb.append(c)
      }
    }
  })
  map.put(sb.length, sb.toString())
  map.headOption.map(_._2).getOrElse("")
}

// wke