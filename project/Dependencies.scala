import sbt._
import Keys._

object Dependencies {

  val logbackclassic =
    "ch.qos.logback" % "logback-classic"  % Versions.logback

  val scalaLogging =
    "com.typesafe.scala-logging" %% "scala-logging" % Versions.scalaLogging

  val scalatest = "org.scalatest" %% "scalatest" % Versions.scalaTest
  val scalacheck = "org.scalacheck" %% "scalacheck" % Versions.scalaCheck


  // required for visual mode
  val scalafx = "org.scalafx" %% "scalafx" % "8.0.102-R11"
}
