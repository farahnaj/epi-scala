package com.epi.scala.clock

object TimeToAngle extends App {

  def timeToAngle(hour: Int, minute: Int = 0): Double = {
    if(notValidInput(hour, minute)) {
      println(s"Invalid input: $hour:$minute")
      0.0
    } else {
      val result = minToAngle(minute) - hourToAngle(hour, minute)
      if(result.abs > 180) {
        println(s"$hour:$minute => ${360.0 - result.abs}")
        360.0 - result.abs
      } else {
        println(s"$hour:$minute => ${result.abs}")
        result.abs
      }
    }
  }

  private def notValidInput(hour: Int, minute: Int): Boolean = {
    (hour <= 0 || hour > 12 || minute < 0 || minute > 60)
  }

  private def hourToAngle(hour: Int, minute: Int = 0): Double = {
    // anglePerHour = 360/12
    val anglePerHour: Double = 30.0

    val offset = if(minute > 0) {
      anglePerHour / (60/minute)
    } else {
      0
    }

    (hour * anglePerHour) + offset
  }

  private def minToAngle(min: Int): Double = {
    // anglePerMinute = 360.0/60
    val anglePerMinute = 6.0
    min * anglePerMinute
  }



  override def main(args: Array[String]): Unit = {
    timeToAngle(12, 30)
    timeToAngle(3, 30)
    timeToAngle(-1, 30)
    timeToAngle(1, 90)
  }

}
