package controllers

import java.util.concurrent.TimeUnit

import actors.Boss
import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import messages.BossMessages.CreateProject
import messages.GeneralMessages.{Err, Response}
import play.api.mvc._


class Application extends Controller {

  val system = ActorSystem("sys")
  implicit val timeout = Timeout(2, TimeUnit.SECONDS)

  import scala.concurrent.ExecutionContext.Implicits.global

  val boss = system.actorOf(Props[Boss], "boss")

  def index = Action {
    Ok("Welcome to Sengab")

  }


  def createUser(username: String) = TODO

  def createProject(name: String) = Action.async {

    val future = boss ? CreateProject(name)
    future map {
      case Response(result) =>
        result
      case Err(result) =>
        result

    }
  }

  def test(ProjectId: String, UserId: String, name: String) = Action {

    request => {
      val body = request.body.asText
      body match {
        case Some(s) =>
          Ok(s"I got project $ProjectId $UserId $name with body $s")
        case None =>
          Ok(s"I got project $ProjectId $UserId $name without body")

      }
    }

  }
}

