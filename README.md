Here we have different ways to do dependency injection (DI) in Scala

---

Each DI style has its own package under [`diip`](https://github.com/olliahonen/diip/tree/master/src/main/scala/diip). They all contain the same program, just wired together in a different way.

* Running `diip.plain.Main.run` prints something like `hej yo hej hej`
* Method `diip.plain.Main.test` emulates a test setup, with the dependency wired to another implementation
* The other `diip.*` packages should work identically
