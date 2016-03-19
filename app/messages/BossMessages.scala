package messages

/**
  * Created by amrelmasry on 3/19/16.
  */
object BossMessages {

  sealed trait UserMessage

  case class CreateUser(username: String) extends UserMessage

  case class UserCreated(username: String) extends UserMessage


  sealed trait Project

  case class CreateProject(projectName: String) extends Project

  case class ProjectCreated(projectName: String) extends Project


}
