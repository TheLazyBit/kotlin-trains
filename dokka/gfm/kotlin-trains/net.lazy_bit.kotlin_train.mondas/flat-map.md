//[kotlin-trains](../index.md)/[net.lazy_bit.kotlin_train.mondas](index.md)/[flatMap](flat-map.md)



# flatMap  
[jvm]  
Brief description  


Returns a value of type [V](flat-map.md) = r ([Either.Right.value](-either/-right/index.md#net.lazy_bit.kotlin_train.mondas/Either.Right/value/#/PointingToDeclaration/)) if this is [Either.Right](-either/-right/index.md) or [V](flat-map.md) = l ([Either.Left.value](-either/-left/index.md#net.lazy_bit.kotlin_train.mondas/Either.Left/value/#/PointingToDeclaration/)) if this is [Either.Left](-either/-left/index.md)

  
Content  
fun <[L](flat-map.md), [R](flat-map.md), [V](flat-map.md)> [Either](-either/index.md)<[L](flat-map.md), [R](flat-map.md)>.[flatMap](flat-map.md)(l: ([L](flat-map.md)) -> [V](flat-map.md), r: ([R](flat-map.md)) -> [V](flat-map.md)): [V](flat-map.md)  



