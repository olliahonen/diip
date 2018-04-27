package diip.implicits

object Main {
  val words = Registry.wordService
  val testWords = TestRegistry.wordService

  def run(): Unit =
    println(words.enlighten(4))

  def test(): Unit =
    println(testWords.enlighten(4))
}

object Registry {
  implicit lazy val wordRepo = new WordRepo
  implicit lazy val wordService = new WordService
}

object TestRegistry {
  implicit lazy val wordRepo = new WordRepoPrint
  implicit lazy val wordService = new WordService
}

class WordService(implicit wordRepo: WordRepo) {
  def enlighten(times: Int): String =
    (1 to times)
      .map(_ => wordRepo.getWord)
      .reduce(_ + " " + _)
}

class WordRepo {
  def getWord = if (Math.random < 0.5) "yo" else "hej"
}

class WordRepoPrint extends WordRepo {
  override def getWord = {
    println("testing...")
    "???"
  }
}
