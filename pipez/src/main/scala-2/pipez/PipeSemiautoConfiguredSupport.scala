package pipez

import scala.language.experimental.macros

/** Mix-in providing `derive` method for semiautomatic `Pipe` derivation without recursion and custom configuration */
trait PipeSemiautoConfiguredSupport[Pipe[_, _]] {

  def derive[In, Out](
    config: PipeDerivationConfig[Pipe, In, Out]
  )(implicit
    pipeDerivation: PipeDerivation[Pipe]
  ): Pipe[In, Out] = macro pipez.internal.Macro.deriveConfigured[Pipe, In, Out]

  object Config {

    def apply[In, Out]: PipeDerivationConfig[Pipe, In, Out] = ???
  }
}
