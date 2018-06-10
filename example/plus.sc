import tf.TF._

val f = implicitly[CCC[Function1]]
val n = implicitly[NumCat[Function1, Int]]

import f._
import n._

val plusC = plus ○ (exl[Int, Int] ap exr[Int, Int])

println(s"Answer to the Ultimate Question of Life, the Universe, and Everything is ${plusC(21, 21)}")

