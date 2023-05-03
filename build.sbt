scalaVersion := "2.13.10"
version := "0.1"
name := "scala-intellij-probs"
resolvers += MavenRepository(
  "HMRC-open-artefacts-maven2",
  "https://open.artefacts.tax.service.gov.uk/maven2"
)

libraryDependencies ++= Seq(
  "uk.gov.hmrc" %% "bootstrap-backend-play-28" % "7.11.0"
)
