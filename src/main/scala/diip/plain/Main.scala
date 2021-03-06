package diip.plain

object Main {
  val words = Registry.wordService
  val testWords = TestRegistry.wordService

  def run(): Unit =
    println(words.enlighten(4))

  def test(): Unit =
    println(testWords.enlighten(4))
}

trait RegistryScheme {
  val wordRepo: WordRepo
  val wordService: WordService
}

object Registry extends RegistryScheme {
  val wordRepo = new WordRepo
  val wordService = new WordService(this)
}

object TestRegistry extends RegistryScheme {
  val wordRepo = new WordRepoPrint
  val wordService = new WordService(this)
}

class WordService(deps: RegistryScheme) {
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
    println("testing...")
    "???"
  }
}
