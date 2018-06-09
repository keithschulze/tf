package tf
package cat

trait CCCInstances {
  implicit val funcCat: CCC[Function1] = instanceOf(
    new CCCClass[Function1] {
      def id[A]: A => A = identity
      def compose[A, B, C]: (B => C) => (A => B) => (A => C) =
        f => g => f compose g
      def ap[A, B, C]: (A => B) => (A => C) => (A => (B, C)) =
        f => g => (a => (f(a), g(a)))
      def exl[A, B]: ((A, B)) => A = _._1
      def exr[A, B]: ((A, B)) => B = _._2
      def apply[A, B]: ((A => B, A)) => B = f => f._1(f._2)
      def curry[A, B, C]: (((A, B)) => C) => (A => (B => C)) =
        f => a => (b => f((a, b)))
      def uncurry[A, B, C]: (A => (B => C)) => (((A, B)) => C) = g => {
        case (a, b) => g(a)(b)
      }
    }
  )
}
