package actors

import akka.actor.Actor
import messages.BossMessages.{ProjectCreated, CreateProject}

/**
  * Created by amrelmasry on 3/19/16.
  */
class Project extends Actor {

  def receive = {
    case CreateProject(n) =>
      context.parent ! ProjectCreated(n)
  }

}
