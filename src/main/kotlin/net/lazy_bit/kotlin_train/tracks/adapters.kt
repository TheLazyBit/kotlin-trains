@file:Suppress("unused")
@file:JvmName("AdapterRails")

package net.lazy_bit.kotlin_train.tracks

import net.lazy_bit.kotlin_train.mondas.*

typealias PlainFunction<IN, OUT> = (IN) -> OUT
typealias DeadEndFunction<IN> = PlainFunction<IN, Unit>
typealias TwoTrackInput<IN, LEFT, OUT> = (Either<LEFT, IN>) -> OUT
typealias TwoTrackOutput<IN, LEFT, OUT> = (IN) -> Either<LEFT, OUT>
typealias SwitchFunction<IN, LEFT, OUT> = TwoTrackOutput<IN, LEFT, OUT>
typealias TwoTrackFunction<IN, LEFT, OUT, NEW_LEFT> = (Either<LEFT, IN>) -> Either<NEW_LEFT, OUT>
typealias Value<L, R> = SwitchFunction<Unit, L, R>
typealias Success<T> = Value<Nothing, T>
typealias Failure<T> = Value<T, Nothing>


/**
 * Convert [PlainFunction] to [SwitchFunction]
 */
fun <IN, LEFT, OUT>PlainFunction<IN, OUT>.switch() : SwitchFunction<IN, LEFT, OUT> = {
    right(this(it))
}

/**
 * Convert [PlainFunction] to [TwoTrackFunction]
 */
fun <IN, LEFT, OUT>SwitchFunction<IN, LEFT, OUT>.bind(): TwoTrackFunction<IN, LEFT, OUT, LEFT> = {
    when (it) {
        is Either.Left -> it
        is Either.Right -> invoke(it.value)
    }
}

/**
 * Converts a [PlainFunction] to a [SwitchFunction] with an embedded TryCatch block
 */
fun <IN, OUT>PlainFunction<IN, OUT>.tryCatch(): SwitchFunction<IN, Throwable, OUT> = {
    try {
        right(this(it))
    }
    catch (e: Exception) {
        left(e)
    }
}

/**
 * Convert a [DeadEndFunction] to a [PlainFunction] that preserves its input as its output
 */
fun <IN> DeadEndFunction<IN>.tee(): PlainFunction<IN, IN> = {
    this(it)
    it
}

/**
 * Combine [SwitchFunction] or [TwoTrackFunction] and a [TwoTrackFunction] to a new [TwoTrackFunction]
 */
infix fun <IN, LEFT, OUT, NEW_OUT>TwoTrackOutput<IN, LEFT, OUT>
        .composeBind(other: TwoTrackFunction<OUT, LEFT, NEW_OUT, LEFT>): TwoTrackOutput<IN, LEFT, NEW_OUT> = {
    when (val res: Either<LEFT, OUT> = this(it)) {
        is Either.Left -> res
        is Either.Right -> other(res)
    }
}


/**
 * Combine two [SwitchFunction]s to a new [SwitchFunction]
 */
infix fun <IN, LEFT, OUT1, OUT2>SwitchFunction<IN, LEFT, OUT1>
        .composeSwitch(other: SwitchFunction<OUT1, LEFT, OUT2>)
        : SwitchFunction<IN, LEFT, OUT2> = {
    when( val res = this(it)) {
        is Either.Left -> res
        is Either.Right -> other(res.value)
    }
}

/**
 * Maps the output of a [TwoTrackOutput] to a new [TwoTrackOutput]
 */
fun <IN, LEFT, OUT, NEW_LEFT, NEW_OUT>TwoTrackOutput<IN, LEFT, OUT>.mapBoth(
    right: PlainFunction<OUT, NEW_OUT>,
    left: PlainFunction<LEFT, NEW_LEFT>
): TwoTrackOutput<IN, NEW_LEFT, NEW_OUT> = {
    when (val res = this(it)) {
        is Either.Left -> left(left(res.value))
        is Either.Right -> right(right(res.value))
    }
}

/**
 * Evaluates [other] with [moreOthers] in parallel with [this] as input and combines their results according
 * to [addRight] and [addLeft] if multiple fail or all succeed.
 */
fun <IN, LEFT, OUT, NEW_OUT>TwoTrackOutput<IN, LEFT, OUT>.composePlus(
    addRight: (NEW_OUT, NEW_OUT) -> NEW_OUT,
    addLeft: (LEFT, LEFT) -> LEFT,
    other: SwitchFunction<OUT, LEFT, NEW_OUT>,
    vararg moreOthers: SwitchFunction<OUT, LEFT, NEW_OUT>
) : TwoTrackOutput<IN, LEFT, NEW_OUT> = {
    when (val res = this(it)) {
        // skip if on failure track
        is Either.Left -> left(res.value)
        // evaluate on success track
        is Either.Right -> moreOthers.fold( other(res.value) ) { acc, function ->
            // for every combined track
            val b = function(res.value)
            // combine their results
            when {
                acc is Either.Right && b is Either.Right -> right(addRight(acc.value, b.value))
                acc is Either.Right && b is Either.Left -> left(b.value)
                acc is Either.Left && b is Either.Right -> left(acc.value)
                acc is Either.Left && b is Either.Left -> left(addLeft(acc.value, b.value))
                else -> error("Can not happen!!!")
            }
        }
    }
}

/**
 * Evaluates [other] with [moreOthers] in parallel with [this] as input and combines their results according
 * to [addRight] and [addLeft] if multiple fail or all succeed.
 */
fun <IN, LEFT, OUT, NEW_OUT>TwoTrackOutput<IN, LEFT, OUT>.composePlus(
    addRight: (NEW_OUT, NEW_OUT) -> NEW_OUT,
    addLeft: (LEFT, LEFT) -> LEFT,
    other: SwitchFunction<OUT, LEFT, NEW_OUT>,
    moreOthers: List<SwitchFunction<OUT, LEFT, NEW_OUT>>
) : TwoTrackOutput<IN, LEFT, NEW_OUT> = this.composePlus(addRight, addLeft, other, *moreOthers.toTypedArray())


/**
 * Turn a value into a [SwitchFunction] on the success track
 */
fun <IN> success(value: IN): Success<IN> = { right(value) }

/**
 * Turn a value into a [SwitchFunction] on the failure track
 */
fun <IN> failure(value: IN): Failure<IN> = { left(value) }

/**
 * Functions with [Unit] as the only parameter can be called without any parameters
 */
operator fun <T>((Unit)->T).invoke(): T = this(Unit)


fun main() {
    val x = success("4") composeSwitch
            {x: String -> x.toInt()}.tryCatch() composeSwitch
            { x: Int -> x*x }.switch()

    println(
        x.mapBoth(
            right = {"Succeeded with `$it`"},
            left = {"Failed with `${it.message}`"}
        )().flatMap(
            l = {it},
            r = {it}
        )
    )

    val y =  x.mapBoth(
        right = {it},
        left = {"Failed with `${it.message}`"}
    ).mapBoth(
        right = {it},
        left = {listOf(it)}
    ).composePlus(
        addRight = { a, b -> a + b},
        addLeft = { a, b -> (a) + (b)},
        { right(it) },
        { right(2) },
        { right(-it) },
        { left(listOf("failure 1")) },
        { left(listOf("failure 2")) },
        { left(listOf("failure 3")) }
    )

    println(
       y()
    )
}