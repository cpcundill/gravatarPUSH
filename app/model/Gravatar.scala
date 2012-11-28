package model

import scala.slick.driver.H2Driver.simple._
import java.security.MessageDigest

case class Gravatar (id : Long, username : String, email : String) {

  def imageUrl = "http://www.gravatar.com/avatar/" + md5((email toLowerCase))

  private def md5(s: String) = {
    val digest = MessageDigest.getInstance("MD5")
    digest.digest(s.getBytes).map("%02x".format(_)).mkString
  }
}

object Gravatars extends Table[Gravatar]("GRAVATAR") {
  def id = column[Long]("ID", O.PrimaryKey)
  def username = column[String]("USERNAME")
  def email = column[String]("EMAIL")
  def * = id ~ username ~ email <> (Gravatar.apply _, Gravatar.unapply _ )
}
