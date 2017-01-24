package $package$

import com.amazonaws.services.lambda.runtime.Context

import scala.beans.BeanProperty

/**
  * This is compatible with aws' lambda JSON to POJO conversion.
  * You can test your lambda by sending it the following payload:
  * {"name": "Bob"}
  */
class LambdaInput() {
  @BeanProperty var name: String = _
}

case class Env(app: String, stack: String, stage: String) {
  override def toString: String = s"App: \$app, Stack: \$stack, Stage: \$stage\n"
}

object Env {
  def apply(): Env = Env(
    Option(System.getenv("App")).getOrElse("DEV"),
    Option(System.getenv("Stack")).getOrElse("DEV"),
    Option(System.getenv("Stage")).getOrElse("DEV")
  )
}

object Lambda {

  /*
   * This is your lambda entry point
   */
  def handler(lambdaInput: LambdaInput, context: Context): Unit = {
    val logger = context.getLogger
    val env = Env()
    logger.log(s"Starting \$env")
    logger.log(process(lambdaInput.name))
  }

  /*
   * I recommend to put your logic outside of the handler
   */
  def process(name: String, env: Env): String = s"Hello \$name! (from \${env.app} in \${env.stack})\n"
}

object TestIt {
  def main(args: Array[String]): Unit = {
    Lambda.handler(args.headOption.getOrElse("Alex"))
  }
}
