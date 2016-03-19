package actors

import akka.actor.Actor
import messages.BossMessages.{UserCreated, CreateUser}

/**
  * Created by amrelmasry on 3/19/16.
  */
class User extends Actor {

  def receive = {
    case CreateUser(n) =>
      context.parent ! UserCreated(n)
  }


}
