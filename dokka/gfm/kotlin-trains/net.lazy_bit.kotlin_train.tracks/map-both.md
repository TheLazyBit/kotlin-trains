//[kotlin-trains](../index.md)/[net.lazy_bit.kotlin_train.tracks](index.md)/[mapBoth](map-both.md)



# mapBoth  
[jvm]  
Brief description  


Maps the output of a [TwoTrackOutput](index.md#net.lazy_bit.kotlin_train.tracks/TwoTrackOutput///PointingToDeclaration/) to a new [TwoTrackOutput](index.md#net.lazy_bit.kotlin_train.tracks/TwoTrackOutput///PointingToDeclaration/)

  
Content  
fun <[IN](map-both.md), [FAILURE](map-both.md), [OUT](map-both.md), [NEW_FAILURE](map-both.md), [NEW_OUT](map-both.md)> [TwoTrackOutput](index.md#net.lazy_bit.kotlin_train.tracks/TwoTrackOutput///PointingToDeclaration/)<[IN](map-both.md), [FAILURE](map-both.md), [OUT](map-both.md)>.[mapBoth](map-both.md)(success: [PlainFunction](index.md#net.lazy_bit.kotlin_train.tracks/PlainFunction///PointingToDeclaration/)<[OUT](map-both.md), [NEW_OUT](map-both.md)>, failure: [PlainFunction](index.md#net.lazy_bit.kotlin_train.tracks/PlainFunction///PointingToDeclaration/)<[FAILURE](map-both.md), [NEW_FAILURE](map-both.md)>): [TwoTrackOutput](index.md#net.lazy_bit.kotlin_train.tracks/TwoTrackOutput///PointingToDeclaration/)<[IN](map-both.md), [NEW_FAILURE](map-both.md), [NEW_OUT](map-both.md)>  



