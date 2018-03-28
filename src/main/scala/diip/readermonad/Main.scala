package diip.readermonad

import scalaz.Reader

object Main {
  val words = Registry.wordService

  def run(): Unit =
    println(^>(words.enlighten(4)))

  private def ^>[T](reader: Reader[RegistryScheme, T]) =
    reader(Registry)
}

trait RegistryScheme {
  val wordRepo: WordRepo
  val wordService: WordService
}

object Registry extends RegistryScheme {
  val wordRepo = new WordRepo
  val wordService = new WordService
}

class WordService {
  def enlighten(times: Int): Reader[RegistryScheme, String] =
    Reader(
      registry =>
        (1 to times)
          .map(_ => registry.wordRepo.getWord)
          .reduce(_ + " " + _)
    )
}

class WordRepo {
  def getWord = if (Math.random < 0.5) "yo" else "hej"
}
