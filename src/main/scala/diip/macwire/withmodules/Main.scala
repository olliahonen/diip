package diip.macwire.withmodules

import diip.macwire.withmodules.repo.{RepoModule, RepoTestModule}
import diip.macwire.withmodules.service.ServiceModule

object Main {
  val registry = new RepoModule with ServiceModule
  val testRegistry = new RepoTestModule with ServiceModule

  val words = registry.wordService
  val testWords = testRegistry.wordService

  def run(): Unit =
    println(words.enlighten(4))

  def test(): Unit =
    println(testWords.enlighten(4))
}
