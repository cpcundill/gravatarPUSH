import sbt._
import PlayProject._

object ApplicationBuild extends Build {

  val appName         = "gravatarPUSH"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "com.typesafe" % "slick_2.10.0-RC1" % "0.11.2"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      // Add your own project settings here      
    )

}
