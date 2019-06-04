package zadania.Lab13

case class Person(name: String, surname: String)
case class Mark(entry1: Int, entry2: Int, entry3: Int)
case class Player(person: Person, mark: Mark)

object Zad1 extends App {

  val players = for {
    _ <- 1 to 15
    person = Generator.person
    mark = Generator.mark
  } yield Player(person, mark)

  players.foreach{ z =>
    println(s"${z.person.name} ${z.person.surname} : ${z.mark.entry1 + z.mark.entry2 + z.mark.entry3}")
  }

}

sealed trait Gender
case object M extends Gender
case object K extends Gender

object Generator {
  import scala.io.Source
  import scala.util.Random

  private val rand = new Random

  def person: Person = ???
  def person(gender: Gender): Person = ???
  def mark: Mark = ???
}
