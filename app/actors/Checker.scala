package actors

import akka.actor.Actor

import scala.collection.mutable.ArrayBuffer

/**
  * Created by amrelmasry on 3/21/16.
  */
class Checker extends Actor {

  var names = ArrayBuffer("")

  override def receive = {
    case name: String =>
      if (names.contains(name)) {
        sender() ! true
      }
      else {
        names += name
        sender() ! false

      }
  }
}
