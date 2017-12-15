name := "randomjavaprogramgenerator"

version := "1.0-SNAPSHOT"

mainClass := Some("main.java.system.controller.Main")

//unmanagedSourceDirectories  in (Compile, run) += file("libMy/jackson-dataformat-yaml-2.9.0.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/jackson-core-2.9.2.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/jackson-databind-2.9.2.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/jackson-annotations-2.9.0.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/org.eclipse.core.commands-3.9.0.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/org.eclipse.core.contenttype-3.6.0.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/org.eclipse.core.expressions-3.6.0.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/org.eclipse.core.filesystem-1.7.0.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/org.eclipse.core.jobs-3.9.1.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/org.eclipse.core.resources-3.12.0.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/org.eclipse.core.runtime-3.13.0.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/org.eclipse.equinox.app-1.3.400.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/org.eclipse.equinox.common-3.9.0.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/org.eclipse.equinox.preferences-3.7.0.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/org.eclipse.equinox.registry-3.7.0.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/org.eclipse.jdt.core-3.13.0.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/org.eclipse.osgi-3.12.50.jar")
//unmanagedSourceDirectories  in (Compile, run) += file("libMy/org.eclipse.text-3.6.100.jar")



libraryDependencies += "commons-io" % "commons-io" % "2.5"
libraryDependencies += "org.osgi" % "org.osgi.core" % "6.0.0"
//libraryDependencies += "org.sonatype.tycho" % "org.eclipse.jdt.core" % "3.6.0.v_A58"
libraryDependencies += "junit" % "junit" % "4.11" % "test"
libraryDependencies += "com.github.mifmif" % "generex" % "0.0.2"
// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.3"
// https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-yaml
libraryDependencies += "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.9.3"
libraryDependencies += "org.osgi" % "org.osgi.core" % "6.0.0"
libraryDependencies += "org.sonatype.tycho" % "org.eclipse.jdt.core" % "3.6.0.v_A58"


