name := "$name;format="normalize"$"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-lambda-java-core" % "1.1.0"
)

enablePlugins(RiffRaffArtifact)

assemblyJarName := s"\${name.value}.jar"
riffRaffPackageType := assembly.value
riffRaffUploadArtifactBucket := Option("riffraff-artifact")
riffRaffUploadManifestBucket := Option("riffraff-builds")
riffRaffArtifactResources += (file("cfn.yaml"), s"\${name.value}-cfn/cfn.yaml")