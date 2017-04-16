package com.epi.scala.graphs.trees


case class Tree(val root: Int, val left: Option[Tree] = None, val right: Option[Tree] = None) {


  //number of nodes in the tree
  def size: Int = {
    1 + left.map(_.size).getOrElse(0) + right.map(_.size).getOrElse(0)
  }

  //Root -> Left -> Right
  def preOrderTraversal: Unit = {
    print(root + " ")

    left match {
      case Some(v) => v.preOrderTraversal
      case None =>
    }

    right match {
      case Some(v) => v.preOrderTraversal
      case None =>
    }
  }

  //Left -> Root -> Right
  def inOrderTraversal: Unit = {
    left match {
      case Some(v) => v.inOrderTraversal
      case None =>
    }

    print(root + " ")

    right match {
      case Some(v) => v.inOrderTraversal
      case None =>
    }
  }

  //Left -> Right -> Root
  def postOrderTraversal: Unit = {
    left match {
      case Some(v) => v.postOrderTraversal
      case None =>
    }

    right match {
      case Some(v) => v.postOrderTraversal
      case None =>
    }

    print(root + " ")
  }
}

object bfs extends App {

  override def main(args: Array[String]): Unit = {

    /**
      *
      *
      *    3
      *  4   5
      * 6 2   8
      * <<3> <4, 5> <6, 2, 8>>
      */

    val myTree = Tree(
      root = 3,
      left = Option(Tree(4, left = Option(Tree(6)),  right = Option(Tree(2)))),
      right = Option(Tree(5, right = Option(Tree(8)))))

    println(s"size of tree: ${myTree.size}")

    println("preOrderTraversal: ")
    myTree.preOrderTraversal //3 4 6 2 5 8

    println("\ninOrderTraversal: ")
    myTree.inOrderTraversal //6 4 2 3 5 8

    println("\npostOrderTraversal: ")
    myTree.postOrderTraversal //6 2 4 8 5 3

  }
}
