import sbtassembly.AssemblyPlugin.autoImport.{assemblyJarName, assemblyMergeStrategy}
import sbtassembly.MergeStrategy

name := "$name;format="normalize"$"

organization := "com.gu"

description:= "$project_description$"

version := "1.0"

scalaVersion := "2.13.3"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-target:jvm-1.8",
  "-Ywarn-dead-code"
)

libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-lambda-java-core" % "$aws_lambda_java_core_version$",
  "com.amazonaws" % "aws-lambda-java-log4j2" % "1.2.0",
  "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.13.3",
  "org.slf4j" % "slf4j-api" % "$slf4j_api_version$"
)

enablePlugins(RiffRaffArtifact)

assemblyJarName := s"\${name.value}.jar"
assemblyMergeStrategy in assembly := {
  case "META-INF/MANIFEST.MF" => MergeStrategy.discard
  case "META-INF/org/apache/logging/log4j/core/config/plugins/Log4j2Plugins.dat" => new MergeLog4j2PluginCachesStrategy
  case _ => MergeStrategy.first
}
riffRaffPackageType := assembly.value
riffRaffUploadArtifactBucket := Option("riffraff-artifact")
riffRaffUploadManifestBucket := Option("riffraff-builds")
riffRaffArtifactResources += (file("cfn.yaml"), s"\${name.value}-cfn/cfn.yaml")
