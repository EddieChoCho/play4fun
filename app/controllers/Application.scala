package controllers

import models.Stock
import play.api._
import play.api.libs.json.Json
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def getStock = Action {
    val stock = Stock("GOOG", 650.0)
    Ok(Json.toJson(stock))
  }

  def saveStock = Action { request =>
    val json = request.body.asJson.get
    val stock = json.as[Stock]
    println(stock)
    Ok
  }
}