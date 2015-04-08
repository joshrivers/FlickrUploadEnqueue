name := "FlickrUploadEnqueue"

organization := "com.riversapps"

version := "0.1.0"

scalaVersion := "2.11.2"

crossScalaVersions := Seq("2.10.4", "2.11.2")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.5" % "test",
  "com.github.seratch" %% "awscala" % "0.4.+",
  "com.typesafe" % "config" % "1.2.1",
  "org.json4s" %% "json4s-jackson" % "3.2.11"
)

initialCommands := "import com.riversapps.flickruploadenqueue._"
