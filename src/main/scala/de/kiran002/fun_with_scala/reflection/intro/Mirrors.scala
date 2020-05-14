package de.kiran002.fun_with_scala.reflection.intro

import scala.reflect.runtime.{universe => ru}

class CustomClass {
    val data = "String"
}

object Mirrors extends App {

    import ru._

    // Runtime mirror (top most mirror)
    val rm = ru.runtimeMirror(this.getClass.getClassLoader)

    val t = typeOf[CustomClass].typeSymbol.asClass
    // Class Mirror
    val cm = rm.reflectClass(t)

    // Constructor Mirror
    val constructorSymbol = ru.termNames.CONSTRUCTOR
    val constructorMethodSymbol = typeOf[CustomClass].decl(constructorSymbol).asMethod
    val constructorMirror = cm.reflectConstructor(constructorMethodSymbol)

    // Instance Mirror
    val obj = new CustomClass()
    val im = rm.reflect(obj)

    // Field mirror
    val term = TermName("data")
    val fieldSymbol = typeOf[CustomClass].decl(term).asTerm
    val fm = im.reflectField(fieldSymbol)

    // Method mirror
    val toStringTerm = TermName("toString")
    val metodSymbol = typeOf[CustomClass].decl(toStringTerm).asMethod
    val mm = im.reflectMethod(metodSymbol)

    // Module mirror
    val moduleTerm = TermName("Mirrors")
    val moduleSymbol = typeOf[CustomClass].decl(moduleTerm).asModule
    val moduleMirror = rm.reflectModule(moduleSymbol)

}
