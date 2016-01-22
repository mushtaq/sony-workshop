package controllers

import _root_.data.{Book, Person, Data}
import org.joda.time.DateTime
import play.api._
import play.api.libs.json.{JsValue, Writes, JsString, Json}
import play.api.mvc._

class Application extends Controller {

  def saveBook() = Action(parse.json) { request =>
    val book = request.body.as[Book]
    println(book)
    Created("saved")
  }

  def index = Action {
    Ok(Json.arr(1, 2, 3, 4))
  }

  def books(name: String) = Action {
    Ok(Json.toJson(Data.bookSet.findByAuthor(name)))
  }

  def books2(names: List[String], title: String) = Action {
    println(names, title)
    Ok(Json.toJson(Data.bookSet.findByAuthors(names)))
  }

  def dates() = Action {
    Ok(Json.toJson(new Person("abc", DateTime.now())))
  }

}
