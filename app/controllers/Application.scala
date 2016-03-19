package controllers

import java.util.concurrent.TimeUnit

import actors.Boss
import messages.BossMessages._
import akka.actor.{Props, ActorSystem}
import akka.util.Timeout
import messages.GeneralMessages.Response
import play.api.mvc._
import akka.pattern.ask

class Application extends Controller {

  val system = ActorSystem("sys")
  implicit val timeout = Timeout(5, TimeUnit.SECONDS)

  import scala.concurrent.ExecutionContext.Implicits.global

  val boss = system.actorOf(Props[Boss], "boss")

  def index = Action {
    Ok("Welcome to Sengab")
  }


  def createUser(username: String) = Action.async {
    boss ? CreateUser(username) map {
      case Response(msg) =>
        Ok(s"User $msg Created")
      case _ =>
        BadRequest("Bad U")
    }
  }

  def createProject(name: String) = Action.async {
    boss ? CreateProject(name) map {
      case Response(msg) =>
        Ok(s"Project $msg Created")
      case _ =>
        BadRequest("Bad U")
    }
  }
}
