---
title: mapRight -
---
//[kotlin-trains](../index.md)/[net.lazy_bit.kotlin_train.mondas](index.md)/[mapRight](map-right.md)



# mapRight  
[jvm]  
Brief description  


Returns a new [Either](-either/index.md) with [Either.Right.value](-either/-right/index.md#net.lazy_bit.kotlin_train.mondas/Either.Right/value/#/PointingToDeclaration/) transformed by block or itself if this is [Either.Left](-either/-left/index.md)

  
Content  
infix fun <[L](map-right.md), [R](map-right.md), [NR](map-right.md)> [Either](-either/index.md)<[L](map-right.md), [R](map-right.md)>.[mapRight](map-right.md)(block: ([R](map-right.md)) -> [NR](map-right.md)): [Either](-either/index.md)<[L](map-right.md), [NR](map-right.md)>  



