import Dependencies._

scalaVersion := "2.12.3"

// factor out common settings into a sequence
lazy val buildSettings = Seq (
  organization := "com.doingfp",
  version := "0.0.1"
)


// Sub-project specific dependencies
libraryDependencies ++= Seq (
  scalafx,
  logbackclassic,
  scalaLogging,
  scalacheck % Test,
  scalatest % Test
)


// Specific locations for src and test
scalaSource in Compile := baseDirectory.value / "src"
scalaSource in Test    := baseDirectory.value / "test"

resourceDirectory in Compile := baseDirectory.value / "resources"
resourceDirectory in Test    := baseDirectory.value / "resources"

// Plugins
enablePlugins(SbtIdeaPlugin)
