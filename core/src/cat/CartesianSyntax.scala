package tf
package cat

import scala.language.experimental.macros

trait CartesianSyntax {
  trait Ops[->[_, _], A, B, C] {
    def typeClassInstance: Cartesian[->]
    def self: A -> B
    def ap(y: A -> C): A -> (B, C) = typeClassInstance.ap(self)(y)
  }

  implicit def toCartesianSyntax[->[_, _], A, B, C](lhs: A -> B)(
      implicit
      cat: Cartesian[->]
  ): Ops[->, A, B, C] = new Ops[->, A, B, C] {
    def self = lhs
    def typeClassInstance = cat
  }
  // implicit final class ToCartesianOps[->[_, _], A, B](cat: A -> B) {
  //   def ap[C](rhs: A -> C)(implicit ev: Cartesian[->]): A -> (B, C) =
  //     macro CCCOperators.binopWithEv[A -> B, Cartesian[->], A -> (B, C)]
  // }
}
