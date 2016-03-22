package messages

import play.api.mvc.Result

/**
  * Created by amrelmasry on 3/19/16.
  */
object GeneralMessages {

  case class Response(result: Result)

  case class Err(result: Result) extends Throwable

}
