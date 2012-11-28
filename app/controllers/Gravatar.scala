package controllers

import play.api.mvc._
import play.db.DB
import java.security.MessageDigest
import model.{Gravatar, Gravatars}
import scala.slick.driver.H2Driver.simple._
import Database.threadLocalSession


object Gravatar extends Controller with Secured {

  def gravatarImage(email: String) = {
    val url = "http://www.gravatar.com/avatar/" + md5((email toLowerCase))
    withAuth{ username => implicit request => Ok(views.html.gravatar(url)) }
  }

  def gravatarList(username: String) = {
    Database.forDataSource(DB.getDataSource()).withSession {
      val query = for(g <- Gravatars if g.username === username) yield g
      val resultList = query.list()
      withAuth { username => implicit request => Ok(views.html.gravatarList(resultList))}
    }
  }

  private def md5(s: String) = {
    val digest = MessageDigest.getInstance("MD5")
    digest.digest(s.getBytes).map("%02x".format(_)).mkString
  }

}