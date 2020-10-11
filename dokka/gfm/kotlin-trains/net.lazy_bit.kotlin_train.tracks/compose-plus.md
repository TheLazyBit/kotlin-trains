//[kotlin-trains](../index.md)/[net.lazy_bit.kotlin_train.tracks](index.md)/[composePlus](compose-plus.md)



# composePlus  
[jvm]  
Brief description  


Evaluates other with moreOthers in parallel with this as input and combines their results according to addSuccess and addFailure if multiple fail or all succeed.

  
Content  
fun <[IN](compose-plus.md), [FAILURE](compose-plus.md), [OUT](compose-plus.md), [NEW_OUT](compose-plus.md)> [TwoTrackOutput](index.md#net.lazy_bit.kotlin_train.tracks/TwoTrackOutput///PointingToDeclaration/)<[IN](compose-plus.md), [FAILURE](compose-plus.md), [OUT](compose-plus.md)>.[composePlus](compose-plus.md)(addSuccess: ([NEW_OUT](compose-plus.md), [NEW_OUT](compose-plus.md)) -> [NEW_OUT](compose-plus.md), addFailure: ([FAILURE](compose-plus.md), [FAILURE](compose-plus.md)) -> [FAILURE](compose-plus.md), other: [SwitchFunction](index.md#net.lazy_bit.kotlin_train.tracks/SwitchFunction///PointingToDeclaration/)<[OUT](compose-plus.md), [FAILURE](compose-plus.md), [NEW_OUT](compose-plus.md)>, vararg moreOthers: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)<out [SwitchFunction](index.md#net.lazy_bit.kotlin_train.tracks/SwitchFunction///PointingToDeclaration/)<[OUT](compose-plus.md), [FAILURE](compose-plus.md), [NEW_OUT](compose-plus.md)>>): [TwoTrackOutput](index.md#net.lazy_bit.kotlin_train.tracks/TwoTrackOutput///PointingToDeclaration/)<[IN](compose-plus.md), [FAILURE](compose-plus.md), [NEW_OUT](compose-plus.md)>  



