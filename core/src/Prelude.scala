package tf

import cat._

trait BaseTypeclasses {
  type InstanceOf[T] = InstanceOfModule.impl.InstanceOf[T]

  @inline
  final def instanceOf[T](t: T): InstanceOf[T] =
    InstanceOfModule.impl.instanceOf(t)

  type Category[->[_, _]] = InstanceOf[CategoryClass[->]]
  type Cartesian[->[_, _]] = InstanceOf[CartesianClass[->]]
  type CCC[->[_, _]] = InstanceOf[CCCClass[->]]
  type Terminal[->[_, _]] = InstanceOf[TerminalClass[->]]
  type ConstCat[->[_, _]] = InstanceOf[ConstCatClass[->]]
  type BoolCat[->[_, _]] = InstanceOf[BoolCatClass[->]]
  type NumCat[->[_, _], A] = InstanceOf[NumCatClass[->, A]]

  final def Category[->[_, _]](implicit P: Category[->]): Category[->] = P
  final def Cartesian[->[_, _]](implicit P: Cartesian[->]): Cartesian[->] = P
  final def CCC[->[_, _]](implicit P: CCC[->]): CCC[->] = P
  final def Terminal[->[_, _]](implicit P: Terminal[->]): Terminal[->] = P
  final def ConstCat[->[_, _]](implicit P: ConstCat[->]): ConstCat[->] = P
  final def BoolCat[->[_, _]](implicit P: BoolCat[->]): BoolCat[->] = P
  final def NumCat[->[_, _], A](implicit P: NumCat[->, A]): NumCat[->, A] = P
}

trait AllSyntax extends cat.CartesianSyntax with cat.CategorySyntax

trait AllInstances
    extends cat.CCCInstances
    with cat.TerminalInstances
    with cat.BoolCatInstances
    with cat.NumCatInstances

object Prelude extends BaseHierarchy

trait LowPriority extends BaseHierarchy with BaseTypeclasses

object TF extends LowPriority with AllSyntax with AllInstances
