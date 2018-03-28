package diip.readermonad

import scalaz.Reader

object Main {
  def run(): Unit =
    new Application(Registry).run()

  def test(): Unit =
    new Application(TestRegistry).run()
}

class Application(registry: RegistryScheme) {
  def run(): Unit =
    println(^>(registry.wordService.enlighten(4)))

  private def ^>[T](reader: Reader[RegistryScheme, T]) =
    reader(registry)
}

trait RegistryScheme {
  val wordRepo: WordRepo
  val wordService: WordService
}

object Registry extends RegistryScheme {
  val wordRepo = new WordRepo
  val wordService = new WordService
}

object TestRegistry extends RegistryScheme {
  val wordRepo = new WordRepoPrint
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

class WordRepoPrint extends WordRepo {
  override def getWord = {
    println("testing...")
    "???"
  }
}
