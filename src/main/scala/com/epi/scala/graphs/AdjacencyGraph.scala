package com.epi.scala.graphs

class AdjacencyGraph(size: Int) {

  val hashMap = new collection.concurrent.TrieMap[Int, List[Int]]()

  def adj(key: Int): List[Int] = {
    hashMap.get(key).getOrElse(List.empty)
  }

  def addEdge(key: Int, value:Int) = {
    hashMap.get(key) match {
      case None => hashMap.put(key , List(value))
      case Some(v) => hashMap.put(key, v ++ List(value))
    }
  }

}

object AdjacencyGraph extends App {
  override def main(args: Array[String]): Unit = {

    val graph = AdjacencyGraph(5)
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(0, 3)
    graph.addEdge(1, 2)
    graph.addEdge(1, 4)
    graph.addEdge(2, 3)
    graph.addEdge(3, 1)
    graph.addEdge(4, 0)
    graph.addEdge(4, 3)

    println(graph.adj(4))

  }

  def apply(size: Int): AdjacencyGraph = new AdjacencyGraph(size)
}
