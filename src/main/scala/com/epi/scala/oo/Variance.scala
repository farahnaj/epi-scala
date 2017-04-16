package com.epi.scala.oo

import com.epi.scala.oo.Covariance.{Animal, Cat, Dog}


/**
  * Variance is a subtyping relationship of complex and component types
  */

class Foo[+A] //A covariant class
class Bar[-A] //A contravariant class
class Baz[A] //An invariant class

object Covariance extends App {
  /**
    * Covariance example:
    * Both Cat and Dog are subtypes of Animal.
    * The Scala standard library has a generic immutable sealed abstract class List[+A] class,
    * where the type parameter A is covariant.
    * This means that a List[Cat] is a List[Animal] and a List[Dog] is also a List[Animal].
    * Intuitively, it makes sense that a list of cats and a list of dogs are each lists of animals,
    * and you should be able to substitute either of them for a List[Animal].
    *
    */
  abstract class Animal {
    def name: String
  }

  case class Cat(name: String) extends Animal
  case class Dog(name: String) extends Animal

  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach { animal =>
      println(animal.name)
    }
  }

  override def main(args: Array[String]): Unit = {
    val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
    val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))
    printAnimalNames(cats)
    // Whiskers
    // Tom
    printAnimalNames(dogs)
    // Fido
    // Rex
  }
}

object Contravariance extends App {

  trait Printer[-A] {
    def print(value: A): Unit
  }

  abstract class Animal {
    def name: String
  }

  case class Cat(name: String) extends Animal {
    //Cat defined it's own printer, but the actual printing happens else where.
    def printMyCat(printer: Printer[Cat]): Unit = {
      printer.print(this)
    }
  }

  //Define different printers for type
  class AnimalPrinter extends Printer[Animal] {
    def print(animal: Animal): Unit =
      println("The animal's name is: " + animal.name)
  }

  class CatPrinter extends Printer[Cat] {
    def print(cat: Cat): Unit =
      println("The cat's name is: " + cat.name)
  }

  override def main(args: Array[String]): Unit = {
    val myCat: Cat = Cat("Boots")

    val catPrinter: Printer[Cat] = new CatPrinter
    val animalPrinter: Printer[Animal] = new AnimalPrinter

    myCat.printMyCat(catPrinter)
    myCat.printMyCat(animalPrinter)
  }
}

/**
  * Generic classes in Scala are invariant by default.
  * In the context of the following example, Container class is invariant.
  * A Container[Cat] is not a Container[Animal], nor is the reverse true.
  *
  * By default Scala uses invariance to protect against mutatation.
 */
object Invariance extends App {

  class Container[A](value: A) {
    private var _value: A = value //value is being mutated, so it is invariant
    def getValue: A = value
    def setValue(value: A) = {
      _value = value
    }
  }

  override def main(args: Array[String]): Unit = {

    /**
      * It may seem like a Container[Cat] should naturally also be a Container[Animal],
      * but allowing a mutable generic class to be covariant would not be safe.
      * In this example, it is very important that Container is invariant.
      * Supposing Container was actually covariant, something like this could happen:
      */

    val catContainer: Container[Cat] = new Container(Cat("Felix"))
    //val animalContainer: Container[Animal] = catContainer //Compiler will complain!!
    val cat = catContainer.getValue
    println(cat)
  }
}


