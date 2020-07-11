package de.kiran002.fun_with_scala.math.kaprekar


object All extends App {

    val all = for {
        i <- 0 to 9
        j <- 0 to 9
        k <- 0 to 9
        l <- 0 to 9
    } yield s"""$i$j$k$l"""

    all.map(x => Kaprekar(x)).filter(_.isValid).foreach(_.process())

}



