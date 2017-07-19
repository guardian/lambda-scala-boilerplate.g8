name := "lambda-scala-boilerplate"
scalaVersion := "2.12.2"
test in Test := {
  val _ = (g8Test in Test).toTask("").value
}
resolvers += Resolver.url("typesafe", url("https://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns)