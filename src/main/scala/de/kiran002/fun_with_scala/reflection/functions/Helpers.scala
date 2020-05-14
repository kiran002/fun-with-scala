package de.kiran002.fun_with_scala.reflection.functions

import scala.reflect.runtime.{universe => ru}
//import de.kiran002.fun_with_scala.reflection.functions.Basic.MyType

object Helpers {

    import ru._

    def printAllMembers[T: TypeTag]: Unit = {
        typeOf[T].members
            .foreach(println)
    }

    def printFields[T: TypeTag]: Unit = {
        typeOf[T].members
            .filter(x => x.asTerm.isVar | x.asTerm.isVal)
            .foreach(println)
    }

    def changeName(obj: MyType, newVal: String): MyType = {
        val rm = ru.runtimeMirror(this.getClass.getClassLoader)
        val nameSymbol = TermName("name")
        val termSymbol = typeOf[MyType].decl(nameSymbol).asTerm
        val im = rm.reflect(obj)
        val fm = im.reflectField(termSymbol)
        fm.set(newVal)
        obj
    }

    def createInstance(name: String, age: Int): MyType = {
        val myTypeObj = typeOf[MyType]
        val rm = ru.runtimeMirror(this.getClass.getClassLoader)
        val cm = rm.reflectClass(myTypeObj.typeSymbol.asClass)
        val mm =
            cm.reflectConstructor(myTypeObj.decl(ru.termNames.CONSTRUCTOR).asMethod)

        val ins = mm(name, age)

        println(ins)
        ins.asInstanceOf[MyType]
    }

    def invokeMethod(a: MyType, methodName: String) = {
        val rm = ru.runtimeMirror(this.getClass.getClassLoader)
        val methodSymbol = typeOf[MyType].decl(TermName(methodName)).asMethod
        val im = rm.reflect(a)
        val mm = im.reflectMethod(methodSymbol)
        mm.apply()
    }
}
