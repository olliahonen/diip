package diip.macwire

import com.softwaremill.macwire.wire

object Main {
  val words = Registry.wordService
  val testWords = TestRegistry.wordService

  def run(): Unit =
    println(words.enlighten(4))

  def test(): Unit =
    println(testWords.enlighten(4))
}

object Registry {
  lazy val wordRepo = wire[WordRepo]
  lazy val wordService = wire[WordService]
}

object TestRegistry {
  lazy val wordRepo = wire[WordRepoPrint]
  lazy val wordService = wire[WordService]
}

class WordService(wordRepo: WordRepo) {
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
