package de.kiran002.fun_with_scala.xml

import com.thoughtworks.xstream.converters.{MarshallingContext, UnmarshallingContext}
import com.thoughtworks.xstream.io.{HierarchicalStreamReader, HierarchicalStreamWriter}


class OptionConverter extends com.thoughtworks.xstream.converters.Converter {

  override def marshal(source: scala.Any, writer: HierarchicalStreamWriter, context: MarshallingContext): Unit = {
    val opt = source.asInstanceOf[Option[_]]
    for (value <- opt) {
      context.convertAnother(opt.get)
    }
  }

  override def unmarshal(reader: HierarchicalStreamReader, context: UnmarshallingContext): AnyRef = {
    throw new UnsupportedOperationException
  }

  override def canConvert(clazz: Class[_]): Boolean = {
    clazz.isAssignableFrom(classOf[Some[_]]) || clazz.isAssignableFrom(None.getClass)
  }
}

class OptionalSequenceConverter extends com.thoughtworks.xstream.converters.Converter {

  private val listOfClasses = List(classOf[MyObj], classOf[MyObj3])

  override def marshal(source: scala.Any, writer: HierarchicalStreamWriter, context: MarshallingContext): Unit = {
    val opt = source match {
      case x: Product => x
    }
    genericMarshall(opt, writer, context)
  }


  def genericMarshall[T <: Product](opt: T, writer: HierarchicalStreamWriter, context: MarshallingContext): Unit = {
    opt.getClass.getDeclaredFields.foreach { x =>
      val value = opt.getClass.getDeclaredField(x.getName) // exception
      value.setAccessible(true) // remote the IllegalAccessException
      value.get(opt) match {
        case n: Option[_] => {
          if (n.isDefined) {
            n.get match {
              case u: Seq[_] => {
                context.convertAnother(u)
              }
              case u: Product => genericMarshall(u, writer, context)
              case u => {
                writer.startNode(x.getName)
                context.convertAnother(u)
                writer.endNode()
              }
            }
          }
        }
        case n: Product => {
          writer.startNode(n.getClass.getName)
          context.convertAnother(n)
          writer.endNode()
        }
        case n => {
          writer.startNode(x.getName)
          context.convertAnother(n)
          writer.endNode()
        }
      }
    }
  }

  override def unmarshal(reader: HierarchicalStreamReader, context: UnmarshallingContext): AnyRef = {
    throw new UnsupportedOperationException
  }

  override def canConvert(clazz: Class[_]): Boolean = {
    false
    listOfClasses.map(x => clazz.isAssignableFrom(x)).reduce((a, b) => a || b)
    //    clazz.isAssignableFrom(classOf[MyObj])
    //    clazz.isAssignableFrom(classOf[Some[_]]) || clazz.isAssignableFrom(None.getClass)
  }
}
