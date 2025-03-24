
**What are generics**

	Generics in Java allows programmers to write "generic" code that enforces some stronger type checks at compile time.

	When you declare an object for the first time, you simply use angle brackets to tell Java the type of the variables you're going to be using.

**Why shall we use generics**

	They allow stornger type checks at compile-time and elimination of constant type casts. They also are good for generic algorithms that are tailored to different types

![[Pasted image 20231123093202.png]]

	But with using generics we can get that following:

![[Pasted image 20231123093245.png]]


**How to use generics**

	This was covered a bit above but when using generics we replace the methods and objects within that class to the generic type which can be a letter such as "T" and this will replace methods/objects and act as its part of the class.

![[Pasted image 20231123093806.png]]

**Note on generics**

	When using generics we are not allowed to use primitive types so we use the object equivalents of the primitive data type.

