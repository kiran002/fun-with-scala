package de.kiran002.fun_with_scala.reflection.type_erasure

import scala.reflect.runtime.universe._
object Answer extends App {

  whatsMyCorrectType("MyString")
  whatsMyCorrectType(2)
  whatsMyCorrectType(Option("MyString"))
  whatsMyCorrectType(Option(234))
  whatsMyCorrectType(Option(List("2", "3")))

  def whatsMyCorrectType[T](ip: T)(implicit tpe: TypeTag[T]) = {
    typeOf[T] match {
      case t if t =:= typeOf[String] => println("I am a string")
      case t if t =:= typeOf[Int]    => println("I am an Integer")
      case t if t =:= typeOf[Option[String]] =>
        println("I am an Optional String")
      case t if t =:= typeOf[Option[Int]] => println("I am an Optional Int")
      case t if t =:= typeOf[Option[List[String]]] =>
        println("I am an Optional list string")
    }
  }

}
