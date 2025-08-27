Haskell is a programming language, and is a functional programming language, meaning it relies on the use of functions. The functions used in Haskell are considered pure, meaning that an input will always have the same output, disallowing functions like `random(upper, lower)`
### laziness
Most programming languages are not lazy, in the sense of when giving an expression, it will evaluate it immediately, but Haskell will only evaluate necessary evaluations, for example the following:
```haskell
naturals = [0, 1, 2, 3..]
```
This is allowed in Haskell syntax, but the main point is that this will not consider every natural number, but only the natural numbers that we consider, and will only compute up to what we desire.
### function declaration
A Haskell declaration looks something like this:
```haskell
triangle n = sum [1 .. n]
```
When calling a function, we do not use brackets, we omit them completely:
```haskell
foo = min(5,6) -- Incorrect
foo = min 5 6 -- Correct
```
We can create much more powerful functions, for example the factorial function:
```haskell
f x = if x == 0 then 1 if else x * f(x - 1)
```
### modules
We separate Haskell code into files, called modules. A module file always starts like this:
```haskell
-- main.hs
module main where

..
```
Haskell filename ends with `.hs`, and is the same as the module name.

Module files can be imported, given that it is reachable:
```haskell
-- Foo.hs
module Foo where
double x = x * 2
```
```haskell
-- Bar.hs
module Bar where
import foo

quadruple x = double (double x)
```
We can also import helpful libraries like it was a module file.
### prelude
One module that is always in scope is called the `prelude` which includes mathematical operators, operators when working with lists, and other widely used Haskell functions.
### definitions
A common file in Haskell would have a series of definitions:
```haskell
-- Definition.hs
module Definition where
triangle n = sum [1 .. n]
```
The LHS will define the function name and the parameters that the RHS can use, in this case `n` is the parameter. 

We can use whitespaces to separate arguments:
```haskell
module maxThree where
max3 x y z = max x (max y z)

biggest = max3 6 (1+3) (2*5)
```
### lambda functions
Whenever we want to perform an expression but do not want to create a whole function for it as it may not be to complex, we can use anonymous functions also known as lambda functions to perform these expressions by using lambda `\`:
```haskell
double = \x -> x * 2 -- double x = x * 2 (This is the function form)
```
The main power of lambda functions are that in-line capabilities that it possess.

Lambda functions can also have multiple arguments and act as a normal function:
```haskell
foo x y = x * y
foo x = \y -> x * y
foo = \x -> \y -> x * y
```
Which would be interpreted by the Haskell compiler as:
```haskell
foo x y = x * y
-- means the same thing as
foo = \x -> \y -> x * y
foo 5 6
>>> (\x -> \y -> x * y) 5 6
>>> (\y -> 5 * y) 6
>>> 5 * 6
>>> 30
```
### partial function
When working with a function, if we do not provide all arguments we will be working with partial functions:
```haskell

```