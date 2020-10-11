//[kotlin-trains](../index.md)/[net.lazy_bit.kotlin_train.mondas](index.md)/[mapLeft](map-left.md)



# mapLeft  
[jvm]  
Brief description  


Returns a new [Either](-either/index.md) with [Either.Left.value](-either/-left/index.md#net.lazy_bit.kotlin_train.mondas/Either.Left/value/#/PointingToDeclaration/) transformed by block or itself if this is [Either.Right](-either/-right/index.md)

  
Content  
infix fun <[L](map-left.md), [R](map-left.md), [NL](map-left.md)> [Either](-either/index.md)<[L](map-left.md), [R](map-left.md)>.[mapLeft](map-left.md)(block: ([L](map-left.md)) -> [NL](map-left.md)): [Either](-either/index.md)<[NL](map-left.md), [R](map-left.md)>  



