
val demoKey = settingKey[Int]("this is the demo key")

demoKey := 100

val copyTaskKey = taskKey[File]("this will copy dist zip to explore folder")

copyTaskKey := {
  val distFile1 = dist.value
  val s = streams.value
  val destinationFile = file("explore") / "demo.zip"
  s.log.info(s"started copying to $destinationFile")
  IO.copyFile(distFile1, destinationFile)
  s.log.info(s"done copying to $destinationFile")
  destinationFile
}

IntegrationTest

name := "sony-workshop"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  ws,
  "org.scala-lang.modules" %% "scala-async" % "0.9.5",
  "com.typesafe.akka" %% "akka-stream-experimental" % "2.0.2",
  "com.typesafe.akka" %% "akka-http-core-experimental" % "2.0.2",
  "com.typesafe.akka" %% "akka-http-experimental" % "2.0.2",

  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
