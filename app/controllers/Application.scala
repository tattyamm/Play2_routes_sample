package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("index"))
  }

  def test11 = Action {
    Ok(views.html.index("test11"))
  }

  def test12(id: Int) = Action {
    Ok(views.html.index("test12 ID:" + id.toString))
  }

  def test13(name: String) = Action {
    Ok(views.html.index("test13 name:" + name))
  }

  def test14(id: Int) = Action {
    Ok(views.html.index("test14 ID:" + id.toString))
  }


  def test21 = Action {
    Ok(views.html.index("test21"))
  }

  def test22(id: Int) = Action {
    Ok(views.html.index("test22 ID:" + id.toString))
  }

  def test23(id: Int) = Action {
    Ok(views.html.index("test23 ID:" + id.toString))
  }

  def test24(name: String) = Action {
    Ok(views.html.index("test24 name:" + name))
  }

  def test25(name: String) = Action {
    Ok(views.html.index("test25 name:" + name))
  }

  def test31 = Action {
    Ok(views.html.index("test31"))
  }

  def test32 = Action {
    Ok(views.html.index("test32"))
  }

  def test33 = Action {
    Ok(views.html.index("test33"))
  }

}