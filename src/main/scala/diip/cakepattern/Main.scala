package diip.cakepattern

object Main {
  val words = Registry.wordService
  val testWords = TestRegistry.wordService

  def run(): Unit =
    println(words.enlighten(4))

  def test(): Unit =
    println(testWords.enlighten(4))
}

object Registry extends
  WordServiceComponent with
  WordRepoComponent {
  val wordService = new WordService
  val wordRepo = new WordRepo
}

object TestRegistry extends
  WordServiceComponent with
  WordRepoComponent {
  val wordService = new WordService
  val wordRepo = new WordRepoPrint
}

trait WordServiceComponent {
  weComeInPeace: WordRepoComponent =>
  val wordService: WordService

  class WordService {
    def enlighten(times: Int): String =
      (1 to times)
        .map(_ => wordRepo.getWord)
        .reduce(_ + " " + _)
  }

}

trait WordRepoComponent {
  val wordRepo: WordRepo

  class WordRepo {
    def getWord = if (Math.random < 0.5) "yo" else "hej"
  }

  class WordRepoPrint extends WordRepo {
    override def getWord = {
      println("testing...")
      "???"
    }
  }

}
