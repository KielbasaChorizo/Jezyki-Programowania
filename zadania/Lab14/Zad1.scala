package zadania.Lab14

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object Zad1 extends App {

  case class Receive(message: String)

  case object Show

  class Coordinator extends Actor {

    override def receive: Receive = {

      case Receive(m: String) =>
        context.become(print(m))
    }

    def print(m: String): Receive = {

      case Show =>
        context.become(receive)
        println(m)
     }

  }

  val system = ActorSystem()
  val coordinator: ActorRef = system.actorOf(Props[Coordinator], "coordinator")

  coordinator ! Receive("Hello world!")
  coordinator ! Show

}
