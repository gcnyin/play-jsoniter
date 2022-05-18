organization := "com.github.gcnyin"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.8"

crossScalaVersions := Seq("2.12.15", "2.13.8")

name := "play-jsoniter"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.8.15" % Provided,
  "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % "2.13.22",
  "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "2.13.22" % "provided"
)

homepage := Some(url("https://github.com/gcnyin/play-jsoniter"))

scmInfo := Some(ScmInfo(url("https://github.com/gcnyin/play-jsoniter"), "https://github.com/gcnyin/play-jsoniter.git"))

developers += Developer("gcnyin", "gcnyin", "guchounongyin@gmail.com", url("https://github.com/gcnyin"))

licenses += ("MIT", url("https://opensource.org/licenses/MIT"))
