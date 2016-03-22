package messages

/**
  * Created by amrelmasry on 3/19/16.
  */
object BossMessages {


  sealed trait ProjectMessage

  case class CreateProject(projectName: String) extends ProjectMessage





}
