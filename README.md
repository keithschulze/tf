# TF - Transcription Factor

Experimenting/playing with Constrained Categories in Scala. Inspired by:

1. [Compiling to Categories by Conal Elliot](http://conal.net/papers/compiling-to-categories/)
2. [`concat` library in Haskell by Conal Elliot](https://github.com/conal/concat)
3. [Blog post by Pascal Voitot on Compiling to Cartesian Closed Categories](https://medium.com/@mandubian/experimental-compiling-scala-into-closed-cartesian-categories-language-using-scalafix-rewriter-4771c6494d38)

Currently only has some core typeclasses (using ScalaZ 8 encoding), so don't expect much yet. About all one can do with it is write functions directly in the CCC encoding and execute using `Function1` category.

Example using [Ammonite](http://ammonite.io):

```
@ import tf._, TF._
import tf._, TF._

@ val f = implicitly[CCC[Function1]]
f: CCC[Function1] = tf.cat.CCCInstances$$anon$1@3cf70afa

@ val e = implicitly[NumCat[Function1, Int]]
e: NumCat[Function1, Int] = tf.cat.NumCatInstances$$anon$1@7dbe858f

@ import f._, e._
import f._, e._

@ def plusC = plus ○ (exl[Int, Int] ap exr[Int, Int])
defined function plusC

@ plusC(0, 0)
res5: Int = 0
```
Note: you can start the Amm repl using: `mill -i "core[2.12.6].repl"`
Builds are defined using [Mill](http://www.lihaoyi.com/mill/).
