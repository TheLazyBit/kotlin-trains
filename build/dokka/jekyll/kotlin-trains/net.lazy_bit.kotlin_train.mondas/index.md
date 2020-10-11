---
title: net.lazy_bit.kotlin_train.mondas -
---
//[kotlin-trains](../index.md)/[net.lazy_bit.kotlin_train.mondas](index.md)



# Package net.lazy_bit.kotlin_train.mondas  


## Types  
  
|  Name|  Summary| 
|---|---|
| [Either](-either/index.md)| [jvm]  <br>Brief description  <br><br><br>An unbiased Either Monad. By convention [Either.Left](-either/-left/index.md) is considered a failure ase and [Either.Right](-either/-right/index.md) a success<br><br>  <br>Content  <br>sealed class [Either](-either/index.md)<out [L](-either/index.md), out [R](-either/index.md)>  <br><br><br>


## Functions  
  
|  Name|  Summary| 
|---|---|
| [flatMap](flat-map.md)| [jvm]  <br>Brief description  <br><br><br>Returns a value of type [V](flat-map.md) = r ([Either.Right.value](-either/-right/index.md#net.lazy_bit.kotlin_train.mondas/Either.Right/value/#/PointingToDeclaration/)) if this is [Either.Right](-either/-right/index.md) or [V](flat-map.md) = l ([Either.Left.value](-either/-left/index.md#net.lazy_bit.kotlin_train.mondas/Either.Left/value/#/PointingToDeclaration/)) if this is [Either.Left](-either/-left/index.md)<br><br>  <br>Content  <br>fun <[L](flat-map.md), [R](flat-map.md), [V](flat-map.md)> [Either](-either/index.md)<[L](flat-map.md), [R](flat-map.md)>.[flatMap](flat-map.md)(l: ([L](flat-map.md)) -> [V](flat-map.md), r: ([R](flat-map.md)) -> [V](flat-map.md)): [V](flat-map.md)  <br><br><br>
| [left](left.md)| [jvm]  <br>Brief description  <br><br><br>Factory method for a [Either.Left](-either/-left/index.md)<br><br>  <br>Content  <br>fun <[L](left.md)> [left](left.md)(value: [L](left.md)): [Either.Left](-either/-left/index.md)<[L](left.md)>  <br><br><br>
| [mapBoth](map-both.md)| [jvm]  <br>Brief description  <br><br><br>Returns a new [Either](-either/index.md) with [Either.Right.value](-either/-right/index.md#net.lazy_bit.kotlin_train.mondas/Either.Right/value/#/PointingToDeclaration/) transformed by r and [Either.Left.value](-either/-left/index.md#net.lazy_bit.kotlin_train.mondas/Either.Left/value/#/PointingToDeclaration/) transformed by l<br><br>  <br>Content  <br>fun <[L](map-both.md), [R](map-both.md), [NL](map-both.md), [NR](map-both.md)> [Either](-either/index.md)<[L](map-both.md), [R](map-both.md)>.[mapBoth](map-both.md)(l: ([L](map-both.md)) -> [NL](map-both.md), r: ([R](map-both.md)) -> [NR](map-both.md)): [Either](-either/index.md)<[NL](map-both.md), [NR](map-both.md)>  <br><br><br>
| [mapLeft](map-left.md)| [jvm]  <br>Brief description  <br><br><br>Returns a new [Either](-either/index.md) with [Either.Left.value](-either/-left/index.md#net.lazy_bit.kotlin_train.mondas/Either.Left/value/#/PointingToDeclaration/) transformed by block or itself if this is [Either.Right](-either/-right/index.md)<br><br>  <br>Content  <br>infix fun <[L](map-left.md), [R](map-left.md), [NL](map-left.md)> [Either](-either/index.md)<[L](map-left.md), [R](map-left.md)>.[mapLeft](map-left.md)(block: ([L](map-left.md)) -> [NL](map-left.md)): [Either](-either/index.md)<[NL](map-left.md), [R](map-left.md)>  <br><br><br>
| [mapRight](map-right.md)| [jvm]  <br>Brief description  <br><br><br>Returns a new [Either](-either/index.md) with [Either.Right.value](-either/-right/index.md#net.lazy_bit.kotlin_train.mondas/Either.Right/value/#/PointingToDeclaration/) transformed by block or itself if this is [Either.Left](-either/-left/index.md)<br><br>  <br>Content  <br>infix fun <[L](map-right.md), [R](map-right.md), [NR](map-right.md)> [Either](-either/index.md)<[L](map-right.md), [R](map-right.md)>.[mapRight](map-right.md)(block: ([R](map-right.md)) -> [NR](map-right.md)): [Either](-either/index.md)<[L](map-right.md), [NR](map-right.md)>  <br><br><br>
| [right](right.md)| [jvm]  <br>Brief description  <br><br><br>Factory method for a [Either.Right](-either/-right/index.md)<br><br>  <br>Content  <br>fun <[R](right.md)> [right](right.md)(value: [R](right.md)): [Either.Right](-either/-right/index.md)<[R](right.md)>  <br><br><br>

