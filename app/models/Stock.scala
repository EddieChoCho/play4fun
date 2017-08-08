package models

/**
  * Created by EddieChoCho on 2017/8/8.
  */
case class Stock(symbol: String, price: Double)
object Stock {
  import play.api.libs.json._
  implicit object StockFormat extends Format[Stock] {

    def reads(json: JsValue): JsResult[Stock] = {
      val symbol = (json \ "symbol").as[String]
      val price = (json \ "price").as[Double]
      JsSuccess(Stock(symbol, price))
    }

    def writes(s: Stock): JsValue = {
      val stockAsList = Seq("symbol" -> JsString(s.symbol),
        "price" -> JsNumber(s.price))
      JsObject(stockAsList)
    }
  }
}
