package de.kiran002.fun_with_scala.currying

import de.kiran002.fun_with_scala.currying.Currying._
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class CurryingTest {

  @Test
  def testSum() = {
    assertEquals(3, sum(x => x)(1, 2))
    assertEquals(3, generic(x => x)((x, y) => x + y)(1, 2))
  }


  @Test
  def testProduct() = {
    assertEquals(2, product(x => x)(1, 2))
    assertEquals(2, generic(x => x)((x, y) => x * y)(1, 2))
  }
}
