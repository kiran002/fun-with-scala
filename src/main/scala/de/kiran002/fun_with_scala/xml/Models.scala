package de.kiran002.fun_with_scala.xml


case class MyObj(a: String, c: MyObj2, b: Option[Seq[String]])

case class MyObj2(c: Option[String], s: String)

case class MyObj3(c: Option[Seq[MyObj2]], s: Option[String])

case class MyObj4(c: Option[Seq[MyObj2]], s: Option[String])

case class MyObj5(c: MyObj, s: Option[String])




