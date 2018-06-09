package tf
package cat

trait CartesianClass[->[_, _]] extends CategoryClass[->] {
  def ap[A, B, C]: (A -> B) => (A -> C) => (A -> (B, C))
  def exl[A, B]: (A, B) -> A
  def exr[A, B]: (A, B) -> B
}
