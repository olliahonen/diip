package diip.implicits

object Main {
  val words = Registry.wordService

  def run(): Unit =
    println(words.enlighten(4))
}

object Registry {
  implicit val wordRepo = new WordRepo
  implicit val wordService = new WordService
}

object AltRegistry {
  implicit val wordRepo = new WordRepoPrint
  implicit val wordService = new WordService
}

class WordService(implicit val wordRepo: WordRepo) {
  def enlighten(times: Int): String =
    if (times < 1) {
      "classic"
    } else {
      (1 to times)
        .map(_ => wordRepo.getWord)
        .reduce(_ + " " + _)
    }
}

class WordRepo {
  def getWord = if (Math.random < 0.5) "yo" else "hej"
}

class WordRepoPrint extends WordRepo {
  override def getWord = {
    println("buu")
    "???"
  }
}
