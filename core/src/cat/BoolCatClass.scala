package tf
package cat

trait BoolCatClass[->[_, _]] extends CartesianClass[->] {
  def not: Boolean -> Boolean
  def and: ((Boolean, Boolean)) -> Boolean
  def or: ((Boolean, Boolean)) -> Boolean
}
