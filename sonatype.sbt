sonatypeProfileName := "es.webbeta"

publishMavenStyle := true

licenses := Seq("MIT" -> url("https://opensource.org/licenses/MIT"))

import xerial.sbt.Sonatype._
sonatypeProjectHosting := Some(GitHubHosting("webbeta", "play-serializer", "moises@webbeta.es"))

homepage := Some(url("https://github.com/webbeta/play-serializer"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/webbeta/play-serializer"),
    "scm:git@github.com:webbeta/play-serializer.git"
  )
)
developers := List(
  Developer(id="mowcixo", name="Moisés Gramary", email="moises@webbeta.es", url=url("http://webbeta.es"))
)