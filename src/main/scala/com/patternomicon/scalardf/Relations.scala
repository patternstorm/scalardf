package com.patternomicon.scalardf

trait Relations {
  self: Individuals =>
  abstract class Relation[r, X[_] <: Individual[_], Y[_] <: Individual[_]]
  abstract class Fact[X[_] <: Individual[_], Y[_] <: Individual[_], x: X, r, y: Y](implicit ev: Relation[r,X, Y])

  object :: {
    implicit object rel extends Relation[::.type, Particular, Universal]
  }

  abstract class ::[x: Particular,y: Universal]
  (implicit ev: Relation[::.type, Particular, Universal])
    extends Fact[Particular, Universal, x, ::.type, y]
}
