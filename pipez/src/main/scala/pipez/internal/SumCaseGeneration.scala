package pipez.internal

trait SumCaseGeneration[Pipe[_, _], In, Out] { self: Definitions[Pipe, In, Out] with Generators[Pipe, In, Out] =>

  trait SumTypeConversion extends CodeGeneratorExtractor {

    final def unapply(settings: Settings): Option[DerivationResult[CodeOf[Pipe[In, Out]]]] = None
  }
  val SumTypeConversion: SumTypeConversion
}
