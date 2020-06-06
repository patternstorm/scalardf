package com.patternomicon.scalardf

trait Persons {
  self: Individuals with Relations =>
  type Person = Person.type
  object Person {
    implicit object universal extends Universal[Person]
  }

  type John = John.type
  object John {
    implicit object particular extends Subject[John]
    implicit object is extends ::[John, Person]
  }

  type Alice = Alice.type
  object Alice {
    implicit object particular extends Subject[Alice]
    implicit object is extends ::[Alice, Person]
  }

  object WorksFor {
    implicit object rel extends Relation[WorksFor.type,Subject,Subject]
  }

  abstract class WorksFor[x: Subject, y: Subject]
  (implicit evx: x :: Person, evy: y :: Person) extends Fact[Subject, Subject, x, WorksFor.type, y]

  implicit object worksFor1 extends WorksFor[John, Alice]

  implicitly[Universal[Person]]
  implicitly[John :: Person]
  implicitly[John WorksFor Alice]

}
