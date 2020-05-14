package de.kiran002.fun_with_scala.reflection.intro


import scala.reflect.runtime.{universe => ru}

object Symbols extends App {

    import ru._
    // TypeSymbols

    //  - ClassSymbols
    val stringClassSymbol = typeOf[String].typeSymbol.asClass
    println(stringClassSymbol)

    // TermSymbols

    // -  MethodSymbols
    // -  ModuleSymbols (object types)
    val symbols = TermName("Symbols")
    val toStringVal = TermName("toString")

}
