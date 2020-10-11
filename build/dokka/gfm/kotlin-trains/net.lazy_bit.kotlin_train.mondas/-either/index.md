//[kotlin-trains](../../index.md)/[net.lazy_bit.kotlin_train.mondas](../index.md)/[Either](index.md)



# Either  
 [jvm] 

An unbiased Either Monad. By convention [Either.Left](-left/index.md) is considered a failure ase and [Either.Right](-right/index.md) a success

sealed class [Either](index.md)<out [L](index.md), out [R](index.md)>   


## Types  
  
|  Name|  Summary| 
|---|---|
| [Left](-left/index.md)| [jvm]  <br>Brief description  <br><br><br>By convention [Either.Left](-left/index.md) is considered to be the failure case for the [Either](index.md) monad<br><br>  <br>Content  <br>data class [Left](-left/index.md)<[L](-left/index.md)>(**value**: [L](-left/index.md)) : [Either](index.md)<[L](-left/index.md), [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)>   <br><br><br>
| [Right](-right/index.md)| [jvm]  <br>Brief description  <br><br><br>By convention [Either.Right](-right/index.md) is considered to be the success case for the [Either](index.md) monad<br><br>  <br>Content  <br>data class [Right](-right/index.md)<[R](-right/index.md)>(**value**: [R](-right/index.md)) : [Either](index.md)<[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html), [R](-right/index.md)>   <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [equals](-right/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)| [jvm]  <br>Content  <br>open operator override fun [equals](-right/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](-right/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)| [jvm]  <br>Content  <br>open override fun [hashCode](-right/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](-right/index.md#kotlin/Any/toString/#/PointingToDeclaration/)| [jvm]  <br>Content  <br>open override fun [toString](-right/index.md#kotlin/Any/toString/#/PointingToDeclaration/)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Inheritors  
  
|  Name| 
|---|
| [Either](-left/index.md)
| [Either](-right/index.md)


## Extensions  
  
|  Name|  Summary| 
|---|---|
| [flatMap](../flat-map.md)| [jvm]  <br>Brief description  <br><br><br>Returns a value of type [V](../flat-map.md) = r ([Either.Right.value](-right/index.md#net.lazy_bit.kotlin_train.mondas/Either.Right/value/#/PointingToDeclaration/)) if this is [Either.Right](-right/index.md) or [V](../flat-map.md) = l ([Either.Left.value](-left/index.md#net.lazy_bit.kotlin_train.mondas/Either.Left/value/#/PointingToDeclaration/)) if this is [Either.Left](-left/index.md)<br><br>  <br>Content  <br>fun <[L](../flat-map.md), [R](../flat-map.md), [V](../flat-map.md)> [Either](index.md)<[L](../flat-map.md), [R](../flat-map.md)>.[flatMap](../flat-map.md)(l: ([L](../flat-map.md)) -> [V](../flat-map.md), r: ([R](../flat-map.md)) -> [V](../flat-map.md)): [V](../flat-map.md)  <br><br><br>
| [mapBoth](../map-both.md)| [jvm]  <br>Brief description  <br><br><br>Returns a new [Either](index.md) with [Either.Right.value](-right/index.md#net.lazy_bit.kotlin_train.mondas/Either.Right/value/#/PointingToDeclaration/) transformed by r and [Either.Left.value](-left/index.md#net.lazy_bit.kotlin_train.mondas/Either.Left/value/#/PointingToDeclaration/) transformed by l<br><br>  <br>Content  <br>fun <[L](../map-both.md), [R](../map-both.md), [NL](../map-both.md), [NR](../map-both.md)> [Either](index.md)<[L](../map-both.md), [R](../map-both.md)>.[mapBoth](../map-both.md)(l: ([L](../map-both.md)) -> [NL](../map-both.md), r: ([R](../map-both.md)) -> [NR](../map-both.md)): [Either](index.md)<[NL](../map-both.md), [NR](../map-both.md)>  <br><br><br>
| [mapLeft](../map-left.md)| [jvm]  <br>Brief description  <br><br><br>Returns a new [Either](index.md) with [Either.Left.value](-left/index.md#net.lazy_bit.kotlin_train.mondas/Either.Left/value/#/PointingToDeclaration/) transformed by block or itself if this is [Either.Right](-right/index.md)<br><br>  <br>Content  <br>infix fun <[L](../map-left.md), [R](../map-left.md), [NL](../map-left.md)> [Either](index.md)<[L](../map-left.md), [R](../map-left.md)>.[mapLeft](../map-left.md)(block: ([L](../map-left.md)) -> [NL](../map-left.md)): [Either](index.md)<[NL](../map-left.md), [R](../map-left.md)>  <br><br><br>
| [mapRight](../map-right.md)| [jvm]  <br>Brief description  <br><br><br>Returns a new [Either](index.md) with [Either.Right.value](-right/index.md#net.lazy_bit.kotlin_train.mondas/Either.Right/value/#/PointingToDeclaration/) transformed by block or itself if this is [Either.Left](-left/index.md)<br><br>  <br>Content  <br>infix fun <[L](../map-right.md), [R](../map-right.md), [NR](../map-right.md)> [Either](index.md)<[L](../map-right.md), [R](../map-right.md)>.[mapRight](../map-right.md)(block: ([R](../map-right.md)) -> [NR](../map-right.md)): [Either](index.md)<[L](../map-right.md), [NR](../map-right.md)>  <br><br><br>

