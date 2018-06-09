package tf
package cat

trait CategoryClass[->[_, _]] {
  def id[A]: A -> A
  def compose[A, B, C]: (B -> C) => (A -> B) => (A -> C)
}
