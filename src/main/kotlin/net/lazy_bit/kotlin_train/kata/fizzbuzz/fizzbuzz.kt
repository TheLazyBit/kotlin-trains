package net.lazy_bit.kotlin_train.kata.fizzbuzz

import net.lazy_bit.kotlin_train.mondas.flatMap
import net.lazy_bit.kotlin_train.mondas.left
import net.lazy_bit.kotlin_train.mondas.right
import net.lazy_bit.kotlin_train.tracks.*

private fun Pair<Int, String>.toFizzBuzzRule(): SwitchFunction<Int, String, Int> = {
    val (divisor, label) = this
    if (it % divisor == 0) {
        left(label)
    }
    else {
        right(it)
    }
}

fun <T>id(): PlainFunction<T, T> = { it }

fun FizzBuzz(
    vararg rules: Pair<Int, String>
) = { input: Int ->
    id<Int>().switch<Int, String, Int>().composePlus(
        addRight = { it: Int, _ -> it },
        addLeft = { a: String, b: String -> "$a $b" },
        id<Int>().switch(),
        rules.map { it.toFizzBuzzRule() }
    ) (input)
        .flatMap(
        l = {it},
        r = {it.toString()}
    )
}


fun main() {

    val fizzbuzz = FizzBuzz(
        3 to "Fizz",
        5 to "Buzz",
        7 to "Fuzz"
    )

    println(fizzbuzz(3))
    println(fizzbuzz(1))
    println(fizzbuzz(5))
    println(fizzbuzz(15))
    println(fizzbuzz(21))
    println(fizzbuzz(3*5*7))
    println(fizzbuzz(25))
}