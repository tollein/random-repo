scalaVersion := "2.11.7"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"
libraryDependencies ++= Seq(
//  "org.scalikejdbc" %% "scalikejdbc"       % "2.4.1",
  "com.h2database"  %  "h2"                % "1.4.191"
//  "ch.qos.logback"  %  "logback-classic"   % "1.1.7"
)
libraryDependencies += "net.sf.opencsv" % "opencsv" % "2.1"
//// https://mvnrepository.com/artifact/com.h2database/h2
//libraryDependencies += "com.h2database" % "h2" % "1.3.148"
