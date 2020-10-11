---
title: composeBind -
---
//[kotlin-trains](../index.md)/[net.lazy_bit.kotlin_train.tracks](index.md)/[composeBind](compose-bind.md)



# composeBind  
[jvm]  
Brief description  


Combine [SwitchFunction](index.md#net.lazy_bit.kotlin_train.tracks/SwitchFunction///PointingToDeclaration/) or [TwoTrackFunction](index.md#net.lazy_bit.kotlin_train.tracks/TwoTrackFunction///PointingToDeclaration/) and a [TwoTrackFunction](index.md#net.lazy_bit.kotlin_train.tracks/TwoTrackFunction///PointingToDeclaration/) to a new [TwoTrackFunction](index.md#net.lazy_bit.kotlin_train.tracks/TwoTrackFunction///PointingToDeclaration/)

  
Content  
infix fun <[IN](compose-bind.md), [FAILURE](compose-bind.md), [OUT](compose-bind.md), [NEW_OUT](compose-bind.md)> [TwoTrackOutput](index.md#net.lazy_bit.kotlin_train.tracks/TwoTrackOutput///PointingToDeclaration/)<[IN](compose-bind.md), [FAILURE](compose-bind.md), [OUT](compose-bind.md)>.[composeBind](compose-bind.md)(other: [TwoTrackFunction](index.md#net.lazy_bit.kotlin_train.tracks/TwoTrackFunction///PointingToDeclaration/)<[OUT](compose-bind.md), [FAILURE](compose-bind.md), [NEW_OUT](compose-bind.md), [FAILURE](compose-bind.md)>): [TwoTrackOutput](index.md#net.lazy_bit.kotlin_train.tracks/TwoTrackOutput///PointingToDeclaration/)<[IN](compose-bind.md), [FAILURE](compose-bind.md), [NEW_OUT](compose-bind.md)>  



