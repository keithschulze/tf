package tf

trait BaseHierarchy extends BaseHierarchy.CC0

object BaseHierarchy {

  trait CC0 extends CC1 {
    implicit def cccToCartesian[F[_, _]](implicit F: CCC[F]): Cartesian[F] =
      instanceOf(F)
    implicit def cccToCategory[F[_, _]](implicit F: CCC[F]): Category[F] =
      instanceOf(F)
    implicit def constCatToTerminal[F[_, _]](
        implicit F: ConstCat[F]): Terminal[F] = instanceOf(F)
  }

  trait CC1 extends CC2 {
    implicit def cartToCategory[F[_, _]](
        implicit F: Cartesian[F]): Category[F] = instanceOf(F)
    implicit def boolToCartesian[F[_, _]](
        implicit F: BoolCat[F]): Cartesian[F] = instanceOf(F)
  }

  trait CC2 extends CC3 {
    implicit def constCatToCategory[F[_, _]](
        implicit F: ConstCat[F]): Category[F] = instanceOf(F)
  }

  trait CC3 extends CC4 {
    implicit def boolToCategory[F[_, _]](implicit F: BoolCat[F]): Category[F] =
      instanceOf(F)
  }

  trait CC4 {
    implicit def termToCategory[F[_, _]](implicit F: Terminal[F]): Category[F] =
      instanceOf(F)
  }

}
