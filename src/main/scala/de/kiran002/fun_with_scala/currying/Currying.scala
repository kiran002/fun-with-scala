package de.kiran002.fun_with_scala.currying

object Currying extends App {

  def sum(f: Int => Int)(a: Int, b: Int) = f(a) + f(b)

  def cube(x: Int) = x * x * x

  def product(f: Int => Int)(a: Int, b: Int) = f(a) * f(b)

  println(sum(x => x)(1, 2))
  println(sum(cube)(1, 2))
  println(product(x => x)(1, 2))
  println(product(cube)(1, 2))

  def generic(f: Int => Int)(g: (Int, Int) => Int)(a: Int, b: Int) = g(f(a), f(b))

  println(generic(x => x)((x, y) => x + y)(1, 2))
  println(generic(cube)((x, y) => x + y)(1, 2))
  println(generic(x => x)((x, y) => x * y)(1, 2))
  println(generic(cube)((x, y) => x * y)(1, 2))

}
