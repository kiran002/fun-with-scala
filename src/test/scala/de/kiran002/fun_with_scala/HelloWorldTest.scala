package de.kiran002.fun_with_scala

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class HelloWorldTest {

  @Test
  def sayHello() = {
    assertEquals("Hello world", HelloWorld.sayHello)
  }
}
