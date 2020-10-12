# kotlin-trains

This an exploring of more functinoal programming, or rather "rails" oriented programming where the Dataflow is modeled 
as if it is running on two rails (Success and Failure).

## Documentation
A technical documentation can be found under the dokka folder.

The project can be devided into 3 modules. Functions, Adapters and Values/Tracks. 

#### Values
Values are represented as an Either monad with Left as the failure track and Right as the success track.

#### Functions
Functions or rather plain functions are standard single valued Functions A -> B

#### Adapters
Adapters transform plain functions into tracked functions and allows the composition of rail pieces.

## TODO
Redefine Either as a function that takes a success / failure function
