package diip

object Main {
  val words = Registry.wordService

  def main(args: Array[String]): Unit = {
    println(words.enlighten(4))
  }
}

object Registry extends
  WordServiceComponent with
  WordRepoComponent {
  val wordService = new WordService
  val wordRepo = new WordRepo
}

trait WordServiceComponent {
  weComeInPeace: WordRepoComponent =>
  val wordService: WordService

  class WordService {
    def enlighten(times: Int): String =
      if (times < 1) {
        "classic"
      } else {
        (1 to times)
          .map(_ => wordRepo.getWord)
          .reduce(_ + " " + _)
      }
  }

}

trait WordRepoComponent {
  val wordRepo: WordRepo

  class WordRepo {
    def getWord = if (Math.random < 0.5) "yo" else "hej"
  }

}
