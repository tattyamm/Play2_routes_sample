package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def test11 = Action {
    Ok(views.html.index("testが呼ばれました。"))
  }

  def test12(id: Int) = Action {
    Ok(views.html.index("testが呼ばれました。ID:" + id.toString))
  }

  def test13(name: String) = Action {
    Ok(views.html.index("testが呼ばれました。name:" + name))
  }

  def test14(id: Int) = Action {
    Ok(views.html.index("testが呼ばれました。ID:" + id.toString))
  }


  def test21 = Action {
    Ok(views.html.index("testが呼ばれました。"))
  }

  def test22(id: Int) = Action {
    Ok(views.html.index("testが呼ばれました。ID:" + id.toString))
  }

  def test23(id: Int) = Action {
    Ok(views.html.index("testが呼ばれました。ID:" + id.toString))
  }

  def test24(name: String) = Action {
    Ok(views.html.index("testが呼ばれました。name:" + name))
  }

  def test25(name: String) = Action {
    Ok(views.html.index("testが呼ばれました。name:" + name))
  }

  def test31 = Action {
    Ok(views.html.index("POSTで呼ばれました。"))
  }
}