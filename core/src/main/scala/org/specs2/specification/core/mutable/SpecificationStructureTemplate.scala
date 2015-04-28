package org.specs2
package specification
package core
package mutable

import specification.dsl.mutable.MutableFragmentBuilder

/**
 * Structure of a decorable mutable specification
 */
trait SpecificationStructureTemplate extends specification.core.SpecificationStructureTemplate with MutableFragmentBuilder {
  def structure = (env: Env) => decorate(specificationStructure(env), env)
}

trait SpecificationStructureIs extends specification.core.SpecificationStructureIs with MutableFragmentBuilder {
  override def structure = (env: Env) => decorate(specificationStructure(env), env)
  def is = structure(Env())
}



