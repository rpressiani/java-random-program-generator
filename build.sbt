name := "randomjavaprogramgenerator"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.4"

unmanagedJars in Compile += file("lib/jackson-dataformat-yaml-2.9.0.jar")
unmanagedJars in Compile += file("lib/jackson-core-2.9.2.jar")
unmanagedJars in Compile += file("lib/jackson-databind-2.9.2.jar")
unmanagedJars in Compile += file("lib/jackson-annotations-2.9.0.jar")
//unmanagedJars in Compile += file("lib/org.eclipse.jft.core-3.12.2.jar")

libraryDependencies += "org.javassist" % "javassist" % "3.19.0-GA"
libraryDependencies += "commons-io" % "commons-io" % "2.5"
libraryDependencies += "org.osgi" % "org.osgi.core" % "6.0.0"
// https://mvnrepository.com/artifact/org.eclipse.jdt/core
libraryDependencies += "org.sonatype.tycho" % "org.eclipse.jdt.core" % "3.6.0.v_A58"
libraryDependencies += "junit" % "junit" % "4.12" % "test"
libraryDependencies += "com.github.mifmif" % "generex" % "0.0.2"
// https://mvnrepository.com/artifact/org.eclipse.core/org.eclipse.core.runtime
libraryDependencies += "org.eclipse.core" % "org.eclipse.core.runtime" % "3.10.0.v20140318-2214"

libraryDependencies += "org.sonatype.tycho" % "org.eclipse.jdt.core" % "3.6.0.v_A58"
// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
//libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.8.9"

