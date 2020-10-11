//[kotlin-trains](../../../index.md)/[net.lazy_bit.kotlin_train.mondas](../../index.md)/[Either](../index.md)/[Left](index.md)



# Left  
 [jvm] 

By convention [Either.Left](index.md) is considered to be the failure case for the [Either](../index.md) monad

data class [Left](index.md)<[L](index.md)>(**value**: [L](index.md)) : [Either](../index.md)<[L](index.md), [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)>    


## Constructors  
  
|  Name|  Summary| 
|---|---|
| [Left](-left.md)|  [jvm] fun <[L](index.md)> [Left](-left.md)(value: [L](index.md))   <br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [component1](component1.md)| [jvm]  <br>Content  <br>operator fun [component1](component1.md)(): [L](index.md)  <br><br><br>
| [copy](copy.md)| [jvm]  <br>Content  <br>fun [copy](copy.md)(value: [L](index.md)): [Either.Left](index.md)<[L](index.md)>  <br><br><br>
| [equals](../-right/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)| [jvm]  <br>Content  <br>open operator override fun [equals](../-right/index.md#kotlin/Any/equals/#kotlin.Any?/PointingToDeclaration/)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)  <br><br><br>
| [hashCode](../-right/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)| [jvm]  <br>Content  <br>open override fun [hashCode](../-right/index.md#kotlin/Any/hashCode/#/PointingToDeclaration/)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)  <br><br><br>
| [toString](../-right/index.md#kotlin/Any/toString/#/PointingToDeclaration/)| [jvm]  <br>Content  <br>open override fun [toString](../-right/index.md#kotlin/Any/toString/#/PointingToDeclaration/)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)  <br><br><br>


## Properties  
  
|  Name|  Summary| 
|---|---|
| [value](index.md#net.lazy_bit.kotlin_train.mondas/Either.Left/value/#/PointingToDeclaration/)|  [jvm] val [value](index.md#net.lazy_bit.kotlin_train.mondas/Either.Left/value/#/PointingToDeclaration/): [L](index.md)   <br>

