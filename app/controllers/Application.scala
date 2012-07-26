package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def test1 = Action {
    Ok(views.html.index("testが呼ばれました。"))
  }

  def test2(id: Int) = Action {
    Ok(views.html.index("testが呼ばれました。" + id.toString))
  }

}