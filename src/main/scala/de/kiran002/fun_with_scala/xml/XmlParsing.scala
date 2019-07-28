package de.kiran002.fun_with_scala.xml

import com.thoughtworks.xstream.XStream
import com.thoughtworks.xstream.io.xml.DomDriver

object XmlParsing extends App {
  private val someStrings = Some(Seq("ab", "aa", "ac"))

  val myObj2 = MyObj2(Some("sai"), "123")
  val myObj2second = MyObj2(Some("s4ai"), "12344")
  val myObj = MyObj("aoaa", myObj2, someStrings)
  val myObj3 = MyObj3(Some(Seq(myObj2, myObj2second)), Some("Hello"))
  val myObj4 = MyObj4(Some(Seq(myObj2, myObj2second)), Some("Hello"))

  val myObj5 = MyObj5(myObj, Some("fgh"))

  implicit val stream: XStream = XStreamConversions(new XStream(new DomDriver))

  stream.aliasSystemAttribute(null, "class")
  stream.registerConverter(new OptionalSequenceConverter)
  stream.registerConverter(new OptionConverter)


  println("Implicit optional sequence of strings")
  println(stream.toXML(myObj))
  println("Implicit optional sequence of case classes")
  println(stream.toXML(myObj3))
  println("Non-Implicit optional sequence of case classes")
  println(stream.toXML(myObj4))
  println("Object and optional string")
  println(stream.toXML(myObj5))
}
