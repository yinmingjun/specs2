package org.specs2
package specification

import main.CommandLine
import specification.core.{SpecificationStructureTemplate, Env, SpecStructure}
import concurrent.ExecutionEnv

/**
 * The CommandLineArgument trait can be mixed-in an Acceptance Specification to
 * access the command line arguments when defining the specification body
 * with the `def is(commandLine: CommandLine)` method
 */
trait CommandLineArguments extends SpecificationStructureTemplate {
  def is(commandLine: CommandLine): SpecStructure
  def structure = (env: Env) => decorate(is(env.arguments.commandLine), env)
}

/**
 * The Environment trait can be mixed-in an Acceptance Specification to
 * access the Env object when defining the specification body
 * with the `def is(env: Env)` method
 */
trait Environment extends SpecificationStructureTemplate {
  def is(env: Env): SpecStructure
  def structure = (env: Env) => decorate(is(env), env)
}

/**
 * The ExecutionEnvironment trait can be mixed-in an Acceptance Specification to
 * access the ExecutionEnv object when defining the specification body
 * with the `def is(implicit ee: ExecutionEnv)` method
 */
trait ExecutionEnvironment extends SpecificationStructureTemplate {
  def is(implicit executionEnv: ExecutionEnv): SpecStructure
  def structure = (env: Env) => decorate(is(env.executionEnv), env)
}

