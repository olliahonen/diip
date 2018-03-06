package diip.structuraltyping

object Main {
  val words = Registry.wordService
  val testWords = TestRegistry.wordService

  def run(): Unit =
    println(words.enlighten(4))

  def test(): Unit =
    println(testWords.enlighten(4))
}

object Registry {
  val wordRepo = new WordRepo
  val wordService = new WordService(this)
}

object TestRegistry {
  val wordRepo = new WordRepoPrint
  val wordService = new WordService(this)
}

class WordService(
  deps: {val wordRepo: WordRepo}
) {
  def enlighten(times: Int): String =
    (1 to times)
      .map(_ => deps.wordRepo.getWord)
      .reduce(_ + " " + _)
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
