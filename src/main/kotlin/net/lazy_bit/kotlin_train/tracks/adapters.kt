@file:Suppress("unused")

package net.lazy_bit.kotlin_train.tracks

import net.lazy_bit.kotlin_train.mondas.*

typealias PlainFunction<IN, OUT> = (IN) -> OUT
typealias DeadEndFunction<IN> = PlainFunction<IN, Unit>
typealias TwoTrackInput<IN, FAILURE, OUT> = (Either<FAILURE, IN>) -> OUT
typealias TwoTrackOutput<IN, FAILURE, OUT> = (IN) -> Either<FAILURE, OUT>
typealias SwitchFunction<IN, FAILURE, OUT> = TwoTrackOutput<IN, FAILURE, OUT>
typealias TwoTrackFunction<IN, FAILURE, OUT, NEW_FAILURE> = (Either<FAILURE, IN>) -> Either<NEW_FAILURE, OUT>
typealias Value<L, R> = SwitchFunction<Unit, L, R>
typealias Success<T> = Value<Nothing, T>
typealias Failure<T> = Value<T, Nothing>


/**
 * Convert [PlainFunction] to [SwitchFunction]
 */
fun <IN, FAILURE, OUT>PlainFunction<IN, OUT>.switch() : SwitchFunction<IN, FAILURE, OUT> = {
    right(this(it))
}

/**
 * Convert [PlainFunction] to [TwoTrackFunction]
 */
fun <IN, FAILURE, OUT>SwitchFunction<IN, FAILURE, OUT>.bind(): TwoTrackFunction<IN, FAILURE, OUT, FAILURE> = {
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
infix fun <IN, FAILURE, OUT, NEW_OUT>TwoTrackOutput<IN, FAILURE, OUT>
        .composeBind(other: TwoTrackFunction<OUT, FAILURE, NEW_OUT, FAILURE>): TwoTrackOutput<IN, FAILURE, NEW_OUT> = {
    when (val res: Either<FAILURE, OUT> = this(it)) {
        is Either.Left -> res
        is Either.Right -> other(res)
    }
}


/**
 * Combine two [SwitchFunction]s to a new [SwitchFunction]
 */
infix fun <IN, FAILURE, OUT1, OUT2>SwitchFunction<IN, FAILURE, OUT1>
        .composeSwitch(other: SwitchFunction<OUT1, FAILURE, OUT2>)
        : SwitchFunction<IN, FAILURE, OUT2> = {
    when( val res = this(it)) {
        is Either.Left -> res
        is Either.Right -> other(res.value)
    }
}

/**
 * Maps the output of a [TwoTrackOutput] to a new [TwoTrackOutput]
 */
fun <IN, FAILURE, OUT, NEW_FAILURE, NEW_OUT>TwoTrackOutput<IN, FAILURE, OUT>.mapBoth(
    success: PlainFunction<OUT, NEW_OUT>,
    failure: PlainFunction<FAILURE, NEW_FAILURE>
): TwoTrackOutput<IN, NEW_FAILURE, NEW_OUT> = {
    when (val res = this(it)) {
        is Either.Left -> left(failure(res.value))
        is Either.Right -> right(success(res.value))
    }
}

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
    val x = success("4s") composeSwitch
            {x: String -> x.toInt()}.tryCatch() composeSwitch
            { x: Int -> x*x }.switch()

    println(
        x.mapBoth(
            success = {"Succeeded with `$it`"},
            failure = {"Failed with `${it.message}`"}
        )().flatMap(
            l = {it},
            r = {it}
        )
    )
}