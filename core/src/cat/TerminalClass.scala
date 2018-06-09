package tf
package cat

trait TerminalClass[->[_, _]] extends CategoryClass[->] {
  def it[A]: A -> Unit
}
