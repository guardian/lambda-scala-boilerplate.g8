package $package$

import com.amazonaws.services.lambda.runtime.Context

/**
  * This is compatible with aws' lambda JSON to POJO conversion.
  * You can test your lambda by sending it the following payload:
  * {"name": "Bob"}
  */
class LambdaInput() {
  var name: String = _
  def getName(): String = name
  def setName(theName: String): Unit = name = theName
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
    logger.log(process(lambdaInput.name, env))
  }

  /*
   * I recommend to put your logic outside of the handler
   */
  def process(name: String, env: Env): String = s"Hello \$name! (from \${env.app} in \${env.stack})\n"
}

object TestIt {
  def main(args: Array[String]): Unit = {
    println(Lambda.process(args.headOption.getOrElse("Alex"), Env()))
  }
}
