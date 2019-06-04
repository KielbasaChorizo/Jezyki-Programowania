package zadania.Lab14

import akka.actor.{Actor, Stash}

object Zad2 {

  case class Receive(m: String)

  class Coordinator extends Actor with Stash {

    def receive: Receive = {
      case "zmien" =>
        unstashAll()
        context.become(innaTozsamosc)
      case "aqq" =>
        println("tak, tak")
      case msg => stash()
    }

    def innaTozsamosc: Receive = {
      case "zmien" =>
        context.become({case msg => println("zzz")})
      case msg =>
        println(s"było: $msg")
    }

  }

}
