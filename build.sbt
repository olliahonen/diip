lazy val root = (project in file("."))
  .settings(
    name := "Diip",
    scalaVersion := "2.12.4",
    libraryDependencies ++= Seq(
      "net.codingwell" %% "scala-guice" % "4.1.1",
      "com.softwaremill.macwire" %% "macros" % "2.3.1" % "provided",
    )
  )
