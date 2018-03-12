lazy val root = (project in file("."))
  .settings(
    name := "Diip",
    scalaVersion := "2.12.4",
    libraryDependencies += "net.codingwell" %% "scala-guice" % "4.1.1"
  )
