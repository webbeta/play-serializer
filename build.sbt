name := "play-serializer"
organization := "es.webbeta"

lazy val root = project.in(file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  cache,
  "es.webbeta" % "serializer" % "1.0.0"
)

publishTo := sonatypePublishTo.value

// workaround for scaladoc error https://github.com/scala/scala-dev/issues/249
// also see http://www.scala-lang.org/news/2.12.0/#scaladoc-can-be-used-to-document-java-sources
scalacOptions in (Compile, doc) ++= {
  if (scalaBinaryVersion.value == "2.11") Nil else Seq("-no-java-comments")
}

javacOptions += "-Xlint:deprecation"
scalacOptions += "-deprecation"
