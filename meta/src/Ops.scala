package tf
package ops

import machinist.{Ops, DefaultOperatorNames}

trait CCCOperatorNames {
  val operatorNames = Map(
    ("\u25CB", "compose"),
    ("\u2A02", "ap")
  )
}

object CCCOperators extends Ops with CCCOperatorNames
