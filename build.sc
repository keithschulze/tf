import mill._, mill.scalalib._, mill.scalalib.scalafmt._
import mill.scalalib.publish._

trait TFModule
    extends CrossScalaModule
    with PublishModule
    with ScalafmtModule {

  def compileIvyDeps = Agg(ivy"org.wartremover::wartremover:2.2.1")
  def scalacPluginIvyDeps = Agg(
    ivy"org.wartremover::wartremover:2.2.1",
    ivy"org.spire-math::kind-projector:0.9.4"
  )

  def scalacOptions = Seq(
    "-P:wartremover:traverser:org.wartremover.warts.Unsafe",
    "-P:wartremover:traverser:org.wartremover.warts.PublicInference",
    "-deprecation",                      // Emit warning and location for usages of deprecated APIs.
    "-encoding", "utf-8",                // Specify character encoding used by source files.
    "-explaintypes",                     // Explain type errors in more detail.
    "-feature",                          // Emit warning and location for usages of features that should be imported explicitly.
    "-language:existentials",            // Existential types (besides wildcard types) can be written and inferred
    "-language:experimental.macros",     // Allow macro definition (besides implementation and application)
    "-language:higherKinds",             // Allow higher-kinded types
    "-language:implicitConversions",     // Allow definition of implicit functions called views
    "-unchecked",                        // Enable additional warnings where generated code depends on assumptions.
    "-Xcheckinit",                       // Wrap field accessors to throw an exception on uninitialized access.
    "-Xfatal-warnings",                  // Fail the compilation if there are any warnings.
    "-Xfuture",                          // Turn on future language features.
    "-Xlint:adapted-args",               // Warn if an argument list is modified to match the receiver.
    "-Xlint:by-name-right-associative",  // By-name parameter of right associative operator.
    "-Xlint:delayedinit-select",         // Selecting member of DelayedInit.
    "-Xlint:doc-detached",               // A Scaladoc comment appears to be detached from its element.
    "-Xlint:inaccessible",               // Warn about inaccessible types in method signatures.
    "-Xlint:infer-any",                  // Warn when a type argument is inferred to be `Any`.
    "-Xlint:missing-interpolator",       // A string literal appears to be missing an interpolator id.
    "-Xlint:nullary-override",           // Warn when non-nullary `def f()' overrides nullary `def f'.
    "-Xlint:nullary-unit",               // Warn when nullary methods return Unit.
    "-Xlint:option-implicit",            // Option.apply used implicit view.
    "-Xlint:package-object-classes",     // Class or object defined in package object.
    "-Xlint:poly-implicit-overload",     // Parameterized overloaded implicit methods are not visible as view bounds.
    "-Xlint:private-shadow",             // A private field (or class parameter) shadows a superclass field.
    "-Xlint:stars-align",                // Pattern sequence wildcard must align with sequence component.
    "-Xlint:type-parameter-shadow",      // A local type parameter shadows a type already in scope.
    "-Xlint:unsound-match",              // Pattern match may not be typesafe.
    "-Yno-adapted-args",                 // Do not adapt an argument list (either by inserting () or creating a tuple) to match the receiver.
    "-Ypartial-unification",             // Enable partial unification in type constructor inference
    "-Ywarn-dead-code",                  // Warn when dead code is identified.
    "-Ywarn-inaccessible",               // Warn about inaccessible types in method signatures.
    "-Ywarn-infer-any",                  // Warn when a type argument is inferred to be `Any`.
    "-Ywarn-nullary-override",           // Warn when non-nullary `def f()' overrides nullary `def f'.
    "-Ywarn-nullary-unit",               // Warn when nullary methods return Unit.
    "-Ywarn-numeric-widen",              // Warn when numerics are widened.
    "-Ywarn-value-discard"
  )

  def publishVersion = "0.1.0"

  def pomSettings = PomSettings(
    description = "Constrained Categories",
    organization = "io.tf",
    url = "https://github.com/keithschulze/tf",
    licenses = Seq(License.MIT),
    versionControl = VersionControl.github("keithschulze", "tf"),
    developers = Seq(
      Developer("keithschulze", "Keith Schulze","https://github.com/keithschulze")
    )
  )
}

object meta extends Cross[MetaModule]("2.11.12", "2.12.6")
class MetaModule(val crossScalaVersion: String) extends TFModule {
  def suffix = T { crossScalaVersion }
  def bigSuffix = T { suffix().toUpperCase() }

  def ivyDeps = Agg(
    ivy"org.typelevel::machinist:0.6.4"
  )
}

object core extends Cross[CoreModule]("2.11.12", "2.12.6")
class CoreModule(val crossScalaVersion: String) extends TFModule {
  def suffix = T { crossScalaVersion }
  def bigSuffix = T { suffix().toUpperCase() }

  def ivyDeps = Agg(
    ivy"org.typelevel::cats-core:1.1.0",
    ivy"com.chuusai::shapeless:2.3.3",
    ivy"org.typelevel::spire:0.14.1",
  )
}

