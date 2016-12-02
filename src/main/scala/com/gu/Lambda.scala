package com.gu

import com.amazonaws.services.lambda.runtime.Context

import scala.beans.BeanProperty

/**
  * This is compatible with aws' lambda JSON to POJO conversion
  */
class LambdaInput() {
  @BeanProperty var name: String = _
}

object Lambda extends App {

  /*
   * These are passed in the CFN template and are lazy due to how the handler is called
   */
  lazy val stack = Option(System.getenv("Stack")).getOrElse("DEV")
  lazy val stage = Option(System.getenv("Stage")).getOrElse("DEV")
  lazy val app = Option(System.getenv("App")).getOrElse("DEV")

  /*
   * This is your lambda entry point
   */
  def handler(lambdaInput: LambdaInput, context: Context): Unit = {
    val logger = context.getLogger
    logger.log(s"Starting App: $app, Stack: $stack, Stage: $stage\n")
    logger.log(process(lambdaInput.name))
  }

  /*
   * I recommend to put your logic outside the handler
   */
  def process(name: String): String = s"Hello $name!\n"

  /*
   * so you can call your logic outside the lambda context, by running sbt run
   */
  println(process("Alex"))
}
