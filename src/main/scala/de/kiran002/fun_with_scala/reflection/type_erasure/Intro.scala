package de.kiran002.fun_with_scala.reflection.type_erasure

object Intro extends App {

  whatsMyType("MyString")
  whatsMyType(2)
  whatsMyType(Option("MyString"))
  whatsMyType(Option(234))
  whatsMyType(Option(List("2", "3")))

  def whatsMyType[T](ip: T) = {
    ip match {
      case _: String         => println("I am a string")
      case _: Int            => println("I am an Integer")
      case _: Option[String] => println("I am an Optional String")
    }
  }
}
