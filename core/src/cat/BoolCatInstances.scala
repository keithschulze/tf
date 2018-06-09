package tf
package cat

trait BoolCatInstances {
  implicit val boolFunc: BoolCat[Function1] = instanceOf(
    new BoolCatClass[Function1] {
      def id[A]: A => A = identity
      def compose[A, B, C]: (B => C) => (A => B) => (A => C) =
        f => g => f compose g
      def ap[A, B, C]: (A => B) => (A => C) => (A => (B, C)) =
        f => g => a => (f(a), g(a))
      def exl[A, B]: ((A, B)) => A = _._1
      def exr[A, B]: ((A, B)) => B = _._2

      def not: Boolean => Boolean = a => !a
      def and: ((Boolean, Boolean)) => Boolean = {
        case (a, b) => a && b
      }
      def or: ((Boolean, Boolean)) => Boolean = {
        case (a, b) => a || b
      }
    }
  )
}
