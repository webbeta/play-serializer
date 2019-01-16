publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

homepage := Some(url("https://github.com/webbeta/play-serializer"))

licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT"))

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra :=
  <scm>
    <url>git@github.com:webbeta/play-serializer.git</url>
    <connection>scm:git:git@github.com:webbeta/play-serializer.git</connection>
  </scm>
  <developers>
    <developer>
      <id>mowcixo</id>
      <name>Moisés Gramary</name>
      <url>http://webbeta.es</url>
    </developer>
  </developers>
