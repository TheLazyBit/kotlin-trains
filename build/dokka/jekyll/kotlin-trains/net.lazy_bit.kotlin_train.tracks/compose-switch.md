---
title: composeSwitch -
---
//[kotlin-trains](../index.md)/[net.lazy_bit.kotlin_train.tracks](index.md)/[composeSwitch](compose-switch.md)



# composeSwitch  
[jvm]  
Brief description  


Combine two [SwitchFunction](index.md#net.lazy_bit.kotlin_train.tracks/SwitchFunction///PointingToDeclaration/)s to a new [SwitchFunction](index.md#net.lazy_bit.kotlin_train.tracks/SwitchFunction///PointingToDeclaration/)

  
Content  
infix fun <[IN](compose-switch.md), [FAILURE](compose-switch.md), [OUT1](compose-switch.md), [OUT2](compose-switch.md)> [SwitchFunction](index.md#net.lazy_bit.kotlin_train.tracks/SwitchFunction///PointingToDeclaration/)<[IN](compose-switch.md), [FAILURE](compose-switch.md), [OUT1](compose-switch.md)>.[composeSwitch](compose-switch.md)(other: [SwitchFunction](index.md#net.lazy_bit.kotlin_train.tracks/SwitchFunction///PointingToDeclaration/)<[OUT1](compose-switch.md), [FAILURE](compose-switch.md), [OUT2](compose-switch.md)>): [SwitchFunction](index.md#net.lazy_bit.kotlin_train.tracks/SwitchFunction///PointingToDeclaration/)<[IN](compose-switch.md), [FAILURE](compose-switch.md), [OUT2](compose-switch.md)>  



