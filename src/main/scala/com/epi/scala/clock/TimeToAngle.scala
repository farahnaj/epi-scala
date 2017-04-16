package com.epi.scala.clock

object TimeToAngle extends App {

  def fancyTimeToAngle(h: Int, m: Int): Double = {
    if(h<=0 || m<0 || h>12 || m>=60){
      println(s"Invalid input: $h:$m")
      0.0
    } else {
      val hour_angle = 0.5 * (h*60 + m)
      val minute_angle = 6 * m
      val angle = (hour_angle - minute_angle).abs
      println(s"$h:$m => ${Math.min(360 - angle, angle)}")
      Math.min(360 - angle, angle)
    }
  }

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
    timeToAngle(9, 0)
    timeToAngle(-1, 30)
    timeToAngle(1, 90)

    fancyTimeToAngle(12, 30)
    fancyTimeToAngle(3, 30)
    fancyTimeToAngle(9, 0)
    fancyTimeToAngle(-1, 30)
    fancyTimeToAngle(1, 90)
  }

}
