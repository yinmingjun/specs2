package org.specs2
package specification.mutable

import main.CommandLine
import org.specs2.concurrent.ExecutionEnv
import org.specs2.specification.core._
import specification.core.mutable.SpecificationStructureTemplate

/**
 * Syntax for building a mutable specifications based on command-line arguments
 *
 * The fragments should be declared as a result of the "def is(commandLine: CommandLine)" method
 *
 */
trait CommandLineArguments extends SpecificationStructureTemplate {
  def is(commandLine: CommandLine): Any

  override def structure = (env: Env) => {
    // trigger the creation of the spec structure through side-effects
    is(env.arguments.commandLine)
    // use what the parent method returns
    super.structure(env)
  }
}

/**
 * Syntax for building a mutable specifications based on the current environment
 */
trait Environment extends SpecificationStructureTemplate {
  def is(env: Env): Any

  override def structure = (env: Env) => {
    // trigger the creation of the spec structure through side-effects
    is(env)
    // use what the parent method returns
    super.structure(env)
  }
}

/**
 * Syntax for building a mutable specifications based on the current environment
 */
trait ExecutionEnvironment extends SpecificationStructureTemplate {
  def is(implicit executionEnv: ExecutionEnv): Any

  override def structure = (env: Env) => {
    // trigger the creation of the spec structure through side-effects
    is(env.executionEnv)
    // use what the parent method returns
    super.structure(env)
  }
}
