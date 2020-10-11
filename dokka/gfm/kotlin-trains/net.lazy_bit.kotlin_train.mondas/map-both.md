//[kotlin-trains](../index.md)/[net.lazy_bit.kotlin_train.mondas](index.md)/[mapBoth](map-both.md)



# mapBoth  
[jvm]  
Brief description  


Returns a new [Either](-either/index.md) with [Either.Right.value](-either/-right/index.md#net.lazy_bit.kotlin_train.mondas/Either.Right/value/#/PointingToDeclaration/) transformed by r and [Either.Left.value](-either/-left/index.md#net.lazy_bit.kotlin_train.mondas/Either.Left/value/#/PointingToDeclaration/) transformed by l

  
Content  
fun <[L](map-both.md), [R](map-both.md), [NL](map-both.md), [NR](map-both.md)> [Either](-either/index.md)<[L](map-both.md), [R](map-both.md)>.[mapBoth](map-both.md)(l: ([L](map-both.md)) -> [NL](map-both.md), r: ([R](map-both.md)) -> [NR](map-both.md)): [Either](-either/index.md)<[NL](map-both.md), [NR](map-both.md)>  



