package de.kiran002.fun_with_scala

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class HelloWorldTest {

  @Test
  def sayHelloWorld() = {
    assertEquals("Hello world", HelloWorld.sayHello)
  }
}
