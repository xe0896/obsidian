**What is a main method?

	A speical method that is the entry point for a java application

**What are normal methods?

	All methods have a signature that defines the name of the method, the return type, the access privilege and the parameters.

**Breaking down the main method

![[Pasted image 20231026092359.png]]

	Access privilages - private, public (or protected)
	Return type - int, double, String and more
	void - a special keyword that the method returns nothing
	Name 
	Comma seperated list of function parameters

**Different between functions and methods

	A function returns a value and will always give an answer whereas a method may not return a value as it may be void.

**The return statement

	If a function has to return a value, we do so with a return, As with variable definitions we need to be sure all code paths lead to a return statement.

**Advanced methods

	We can have mutiple methods with the same name

	Methods are defined by their name, return types and their parameter types 

	Having multiple methods with different parameter lists is called function overloading

![[Pasted image 20231026094140.png]]

**Scope

	Variables have scope from the moment they are declared, until the block its declared within is closed.

	If we want a variable to be accessible in many methods we can declare class variables, if we define a variabe outside of a method, but within the class, it will have scope in every single method in the class.

![[Pasted image 20231026095008.png]]

**Passing parameters by value

	The 8 primitive types are always passed by value, when we call a method the value of the variable we pass is cloned in memory, any changes to the variable only occur on the cloned value and do not affect the original variable.

![[Pasted image 20231026095155.png]]

**Objects and arrays with functions

	Object types (like String) and arrays are passed differently to functions, the actual memory address of the variable is used which means that the contents are changed, this is called parameter passing by the value of the reference.

![[Pasted image 20231026095327.png]]

	Passing value by reference can be seen below as troublesome as if we do m = n; then n will be changed to have no contents as it will copy its memory address and therefore change its contents, to counter-act we can use a for loop to iterate through the array that has contents and let the iterative constant to access the index of the content .