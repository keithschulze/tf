package tf
package cat

trait NumCatClass[->[_, _], A] {
  def negate: A -> A
  def plus: (A, A) -> A
  def minus: (A, A) -> A
  def times: (A, A) -> A
  def div: (A, A) -> A
}
