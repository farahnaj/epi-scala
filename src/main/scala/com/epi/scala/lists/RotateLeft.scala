package com.epi.scala.lists

import scala.collection.mutable.ArrayBuffer

object RotateLeft extends App {

  def rotateLeft(rotations: Int, input: List[Int]) = {
    println(input.drop(rotations) ++ input.take(rotations))
  }

  override def main(args: Array[String]): Unit = {
    rotateLeft(2, List(1,2,3,4,5))
  }
}
