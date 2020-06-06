package com.patternomicon.scalardf

trait Individuals {

  sealed trait Individual[x]
  trait Particular[x] extends Individual[x]
  trait Universal[x] extends Individual[x]
  trait Subject[x] extends Particular[x]
  trait Value[x] extends Particular[x]
}
