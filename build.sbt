name := "play-serializer"

lazy val root = project.in(file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

// TODO: Enable as soon Play supports Scala 2.13:
//crossScalaVersions := Seq("2.12.7", "2.13.0-M5")

organization := "es.webbeta"

libraryDependencies ++= Seq(
  cache,
  "es.webbeta" % "serializer" % "1.0.0"
)

releasePublishArtifactsAction := PgpKeys.publishSigned.value

// workaround for scaladoc error https://github.com/scala/scala-dev/issues/249
// also see http://www.scala-lang.org/news/2.12.0/#scaladoc-can-be-used-to-document-java-sources
scalacOptions in (Compile, doc) ++= {
  if (scalaBinaryVersion.value == "2.11") Nil else Seq("-no-java-comments")
}

javacOptions += "-Xlint:deprecation"
scalacOptions += "-deprecation"

resolvers += Resolver.sonatypeRepo("snapshots")
