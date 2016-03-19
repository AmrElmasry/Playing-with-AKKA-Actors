package actors

import akka.actor.{ActorRef, Props, Actor}
import messages.BossMessages._
import messages.GeneralMessages.Response

/**
  * Created by amrelmasry on 3/19/16.
  */
class Boss extends Actor {

  var out: ActorRef = null

  val user = context.actorOf(Props[User], "user")
  val project = context.actorOf(Props[Project], "project")


  def receive = {

    case CreateUser(username) =>
      out = sender()
      user ! CreateUser(username)
    case UserCreated(name) =>
      out ! Response(name)


    case CreateProject(name) =>
      out = sender()
      project ! CreateProject(name)


    case ProjectCreated(name) =>
      out ! Response(name)


  }


}
