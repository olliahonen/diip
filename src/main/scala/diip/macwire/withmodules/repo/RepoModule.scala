package diip.macwire.withmodules.repo

import com.softwaremill.macwire.wire
import diip.macwire.{WordRepo, WordRepoPrint}

trait RepoModule {
  lazy val wordRepo = wire[WordRepo]
}

trait RepoTestModule {
  lazy val wordRepo = wire[WordRepoPrint]
}
