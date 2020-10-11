package net.lazy_bit.kotlin_train.mondas

fun <L> left(value: L) = Either.Left(value)
fun <R> right(value: R) = Either.Right(value)
sealed class Either<out L, out R> {
    data class Left<L>(val value: L) : Either<L, Nothing>()
    data class Right<R>(val value: R) : Either<Nothing, R>()
}

infix fun <L, R, NL>Either<L, R>.mapLeft(block: (L) -> NL): Either<NL, R> = when(this) {
    is Either.Left -> left(block(value))
    is Either.Right -> this
}

infix fun <L, R, NR>Either<L, R>.mapRight(block: (R) -> NR): Either<L, NR> = when(this) {
    is Either.Left -> this
    is Either.Right -> right(block(value))
}

fun <L, R, NL, NR>Either<L, R>.mapBoth(l: (L) -> NL, r: (R) -> NR): Either<NL, NR> = when(this) {
    is Either.Left -> left(l(value))
    is Either.Right -> right(r(value))
}

fun <L, R, V>Either<L, R>.flatMap(l: (L) -> V, r: (R) -> V): V = when(this) {
    is Either.Left -> l(value)
    is Either.Right -> r(value)
}