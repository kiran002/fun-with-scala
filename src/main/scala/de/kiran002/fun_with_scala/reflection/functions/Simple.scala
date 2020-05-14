package de.kiran002.fun_with_scala.reflection.functions

import de.kiran002.fun_with_scala.reflection.functions.Helpers._

case class MyType(name: String, age: Int) {

    def isMinor: Unit = println(s"Age is minor : ${age < 18}")
}

object Simple extends App {
    // General actions with Reflection
    //Inspect contents of class
    printAllMembers[MyType]
    // inspect fields
    printFields[MyType]
    //Create instance of a type
    val ins = createInstance("sai", 29)
    // change value of an instance
    println(changeName(ins, "Sai"))
    //invoke methods on an instance
    invokeMethod(ins, "isMinor")

}
