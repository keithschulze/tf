package tf
package cat

import spire.math._

trait NumCatInstances {
  implicit def numFunc[A: Numeric]: NumCat[Function1, A] = instanceOf(
    new NumCatClass[Function1, A] {
      val op = implicitly[Numeric[A]]

      def negate: A => A = op.negate
      def plus: ((A, A)) => A = {
        case (a, b) => op.plus(a, b)
      }
      def minus: ((A, A)) => A = {
        case (a, b) => op.minus(a, b)
      }
      def times: ((A, A)) => A = {
        case (a, b) => op.times(a, b)
      }
      def div: ((A, A)) => A = {
        case (a, b) => op.div(a, b)
      }
    }
  )
}
