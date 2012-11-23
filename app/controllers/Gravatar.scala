package controllers

import play.api.mvc._
import java.security.MessageDigest

object Gravatar extends Controller with Secured {

  def gravatarImage(email: String) = {
    val url = "http://www.gravatar.com/avatar/" + md5((email toLowerCase))
    withAuth{ username => implicit request => Ok(views.html.gravatar(url)) }
  }

  private def md5(s: String) = {
    val digest = MessageDigest.getInstance("MD5")
    digest.digest(s.getBytes).map("%02x".format(_)).mkString
  }

}