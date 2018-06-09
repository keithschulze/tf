package tf
package cat

trait CCCClass[->[_, _]] extends CartesianClass[->] {
  def apply[A, B]: ((A -> B), A) -> B
  def curry[A, B, C]: ((A, B) -> C) => (A -> (B -> C))
  def uncurry[A, B, C]: (A -> (B -> C)) => ((A, B) -> C)
}
