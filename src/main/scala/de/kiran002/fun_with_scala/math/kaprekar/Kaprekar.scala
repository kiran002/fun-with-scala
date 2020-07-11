package de.kiran002.fun_with_scala.math.kaprekar

case class Kaprekar(input: String, printIntermediate: Boolean = false) {

    val Constant = 6174


    def isValid: Boolean = {
        input.length == 4 && sameDigitsCheck
    }

    def process(): Unit = {
        var res = -1
        var ip = input
        var iterations = 0
        do {
            res = calculate(ip)
            ip = res.toString.padTo(4, '0')
            iterations += 1
        } while (res != Constant)
        println(s"Took ${iterations} Iterations for ${input} to converge to ${Constant}")
    }

    private def calculate(ip: String): Int = {
        val lowVal = ascending(ip)
        val highVal = descending(ip)
        val res = highVal - lowVal
        if (printIntermediate) println(s"High Value : $highVal , Low Value: $lowVal and difference $res")
        res
    }

    private def sameDigitsCheck: Boolean = {
        val lowVal = ascending(input)
        val highVal = descending(input)
        highVal - lowVal != 0
    }


    private def ascending(ip: String): Int = {
        ip.map(x => x.toString.toInt).toList.sorted.mkString.toInt
    }


    private def descending(ip: String): Int = {
        ip.map(x => x.toString.toInt).toList.sorted(Ordering.Int.reverse).mkString.toInt
    }


}
