package tf
package cat

trait TerminalInstances {
  implicit val termFunc: ConstCat[Function1] = instanceOf(
    new ConstCatClass[Function1] {
      def id[A]: A => A = identity
      def compose[A, B, C]: (B => C) => (A => B) => (A => C) =
        f => g => f compose g
      def it[A]: A => Unit = _ => ()
      def unitArrow[B]: B => (Unit => B) = b => (Unit => b)
    }
  )
}
