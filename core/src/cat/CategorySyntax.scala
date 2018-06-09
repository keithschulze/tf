package tf
package cat

import scala.language.experimental.macros

trait CategorySyntax {
  trait Ops[->[_, _], A, B, C] {
    def typeClassInstance: Category[->]
    def self: B -> C
    def ○(y: A -> B): A -> C = typeClassInstance.compose(self)(y)
  }

  implicit def toCategorySyntax[->[_, _], A, B, C](lhs: B -> C)(
      implicit
      cat: Category[->]
  ): Ops[->, A, B, C] = new Ops[->, A, B, C] {
    def self = lhs
    def typeClassInstance = cat
  }
  // implicit final class ToCategoryOps[->[_, _], B, C](cat: B -> C) {
  //   def compose[A](rhs: A -> B)(implicit ev: Category[->]): A -> C =
  //     macro CCCOperators.binopWithEv[B -> C, Category[->], A -> C]
  // }
}
