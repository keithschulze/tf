package tf
package cat

trait ConstCatClass[->[_, _]] extends TerminalClass[->] {
  def unitArrow[B]: B => (Unit -> B)
}
