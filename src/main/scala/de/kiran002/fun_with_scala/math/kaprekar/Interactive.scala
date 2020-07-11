package de.kiran002.fun_with_scala.math.kaprekar

import java.util.Scanner

object Interactive extends App {

    val in = new Scanner(System.in)
    var quit = false

    do {
        println("Enter a four digit number (not all digits should be equal)")
        val input = in.nextLine()
        val k = Kaprekar(input, true)
        if (!k.isValid) println("Not a valid number")
        else k.process()
        println("Do you want to quit? (q for yes, anything else for no)")
        val quitAnswer = in.nextLine()
        if (quitAnswer.equals("q")) quit = true
    } while (!quit)

}
