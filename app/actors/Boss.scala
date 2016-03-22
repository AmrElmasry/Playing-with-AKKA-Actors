package actors

import akka.actor.{ActorRef, Props, Actor}
import messages.BossMessages._

/**
  * Created by amrelmasry on 3/19/16.
  */
class Boss extends Actor {


  var out: ActorRef = null
  val checker = context.actorOf(Props[Checker])


  def receive = {
    case CreateProject(name) =>
      val project = context.actorOf(Project.props(checker))
      out = sender()
      project forward CreateProject(name)


  }


}
