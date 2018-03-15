package diip.macwire.withmodules.service

import com.softwaremill.macwire.wire
import diip.macwire.{WordRepo, WordService}

trait ServiceModule {
  lazy val wordService = wire[WordService]

  def wordRepo: WordRepo
}
