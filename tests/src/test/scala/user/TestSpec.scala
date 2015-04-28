package user

import org.specs2._
import org.specs2.main.Arguments
import org.specs2.specification.core.{SpecStructure, SpecificationStructure, Env}

class TestSpec extends Specification with ScalaCheck with DynamoDb { def is(client: DynamoClient) = stopOnFail ^ s2"""

  start    ${step(startDb(client))}
  stop     ${step(stopDb(client))}

"""

  def startDb(client: DynamoClient) =
    println("start db")

  def stopDb(client: DynamoClient) =
    println("stop db")
}

trait DynamoDb extends SpecificationStructure {

  def is(client: DynamoClient): SpecStructure

  override def structure = (env: Env) => decorate(is(createClient(env.arguments)), env)

  /** create a client from the arguments */
  def createClient(arguments: Arguments): DynamoClient =
    DynamoClient(args: Arguments)
}

case class DynamoClient(args: Arguments)
