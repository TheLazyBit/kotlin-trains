package net.lazy_bit.kotlin_train.mondas

/**
 * Factory method for a [Either.Left]
 */
fun <L> left(value: L) = Either.Left(value)

/**
 * Factory method for a [Either.Right]
 */
fun <R> right(value: R) = Either.Right(value)

/**
 * An unbiased Either Monad. By convention [Either.Left] is considered a failure ase and [Either.Right] a success
 */
sealed class Either<out L, out R> {
    /**
     * By convention [Either.Left] is considered to be the failure case for the [Either] monad
     */
    data class Left<L>(val value: L) : Either<L, Nothing>()
    /**
     * By convention [Either.Right] is considered to be the success case for the [Either] monad
     */
    data class Right<R>(val value: R) : Either<Nothing, R>()
}

/**
 * Returns a new [Either] with [Either.Left.value] transformed by [block] or itself if this is [Either.Right]
 */
infix fun <L, R, NL>Either<L, R>.mapLeft(block: (L) -> NL): Either<NL, R> = when(this) {
    is Either.Left -> left(block(value))
    is Either.Right -> this
}

/**
 * Returns a new [Either] with [Either.Right.value] transformed by [block] or itself if this is [Either.Left]
 */
infix fun <L, R, NR>Either<L, R>.mapRight(block: (R) -> NR): Either<L, NR> = when(this) {
    is Either.Left -> this
    is Either.Right -> right(block(value))
}

/**
 * Returns a new [Either] with [Either.Right.value] transformed by [r] and [Either.Left.value] transformed by [l]
 */
fun <L, R, NL, NR>Either<L, R>.mapBoth(l: (L) -> NL, r: (R) -> NR): Either<NL, NR> = when(this) {
    is Either.Left -> left(l(value))
    is Either.Right -> right(r(value))
}

/**
 * Returns a value of type
 *  [V] = [r] ([Either.Right.value]) if this is [Either.Right]
 *  or
 *  [V] = [l] ([Either.Left.value]) if this is [Either.Left]
 */
fun <L, R, V>Either<L, R>.flatMap(l: (L) -> V, r: (R) -> V): V = when(this) {
    is Either.Left -> l(value)
    is Either.Right -> r(value)
}