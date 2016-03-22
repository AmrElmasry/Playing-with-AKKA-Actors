package actors

import java.util.concurrent.TimeUnit

import akka.actor.{ActorRef, Actor, Props}
import akka.util.Timeout
import messages.BossMessages.CreateProject

import akka.pattern.ask
import akka.pattern.pipe
import messages.GeneralMessages.Response
import play.api.mvc.Results

/**
  * Created by amrelmasry on 3/19/16.
  */
class Project(checker: ActorRef) extends Actor {

  implicit val timeout = Timeout(2, TimeUnit.SECONDS)

  import scala.concurrent.ExecutionContext.Implicits.global


  def receive = {
    case CreateProject(name) =>
      val future = checker ? name map {
        case true =>
          // created before
          Response(Results.BadRequest("Created before !!"))
        case false =>
          // new one, created
          Response(Results.Created(s"project $name created"))
      }

      future pipeTo sender()
      context.stop(self)

  }

}


object Project {
  def props(checker: ActorRef): Props = Props(new Project(checker))
}
