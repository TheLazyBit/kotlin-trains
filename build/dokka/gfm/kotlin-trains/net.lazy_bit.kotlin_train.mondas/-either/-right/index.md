//[kotlin-trains](../../../index.md)/[net.lazy_bit.kotlin_train.mondas](../../index.md)/[Either](../index.md)/[Right](index.md)



# Right  
 [jvm] 

By convention [Either.Right](index.md) is considered to be the success case for the [Either](../index.md) monad

data class [Right](index.md)<[R](index.md)>(**value**: [R](index.md)) : [Either](../index.md)<[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html), [R](index.md)>    


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [Right](-right.md)|  [jvm] fun <[R](index.md)> [Right](-right.md)(value: [R](index.md))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [component1](component1.md)| [jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [R](index.md)  <br><br><br>
| [copy](copy.md)| [jvm]  <br>Content  <br>fun [copy](copy.md)(value: [R](index.md)): [Either.Right](index.md)<[R](index.md)>  <br><br><br>
| [equals](index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)| [jvm]  <br>Content  <br>open operator override fun [equals](index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)| [jvm]  <br>Content  <br>open override fun [hashCode](index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](index.md#kotlin/Any/toString/#/PointingToDeclaration/)| [jvm]  <br>Content  <br>open override fun [toString](index.md#kotlin/Any/toString/#/PointingToDeclaration/)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [value](index.md#net.lazy_bit.kotlin_train.mondas/Either.Right/value/#/PointingToDeclaration/)|  [jvm] val [value](index.md#net.lazy_bit.kotlin_train.mondas/Either.Right/value/#/PointingToDeclaration/): [R](index.md)   <br>

