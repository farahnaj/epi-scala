import scala.collection.mutable.ArrayBuffer

def partition(array: ArrayBuffer[Int], target: Int, pivot: Int) = {
  var i = -1
  val pivotElem = array.apply(pivot)
  var finalTarget = pivot

  for (target <- target until array.length) {

    val targetElem = array.apply(target)

    if (targetElem <= pivotElem) {
      i = i + 1
      val idex = i
      val iElem = array.apply(idex)
      array.update(idex, targetElem)
      array.update(target, iElem)
      finalTarget = target
    }
  }
  (array, finalTarget)
}

val l = ArrayBuffer(6,8,7,2,4,3,5)
partition(l,0,6)

def qs(array: ArrayBuffer[Int], target: Int, pivot: Int) = {
  val result = partition(array, target, pivot)
  partition(result._1, 0, result._2 - 1)
  partition(result._1, result._2 + 1, pivot)

  array
}

