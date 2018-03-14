package diip.guice

import javax.inject.Inject
import com.google.inject.{AbstractModule, Guice}
import net.codingwell.scalaguice.ScalaModule
import net.codingwell.scalaguice.InjectorExtensions._

object Main {
  val words = Guice.createInjector().instance[WordService]
  val testWords = Guice.createInjector(TestRegistry).instance[WordService]

  def run(): Unit =
    println(words.enlighten(4))

  def test(): Unit =
    println(testWords.enlighten(4))
}

object TestRegistry extends AbstractModule with ScalaModule {
  def configure(): Unit =
    bind[WordRepo].to[WordRepoPrint]
}

class WordService @Inject()(wordRepo: WordRepo) {
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
