//scalaVersion := "2.13.0"
scalacOptions ++= Seq("-language:implicitConversions", "-deprecation")
mainClass := Some("com.obelov.mainclass.HelloWorld")

resolvers in ThisBuild += Resolver.jcenterRepo

libraryDependencies ++= Seq(
  "net.aichler" % "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test
)

testOptions += Tests.Argument(jupiterTestFramework, "-s", "-a", "-q", "-v")
