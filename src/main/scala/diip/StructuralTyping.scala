package diip

object StructuralTyping {
  def ok(stru: {def callMe(in: Int): Int}): Unit =
    println(stru.callMe(8))

  class Inverter {
    def callMe(in: Int) = -in
  }

  class TenFolder {
    def callMe(in: Int) = 10 * in
  }

  def doIt(): Unit = {
    ok(new Inverter)
    ok(new TenFolder)
  }
}
