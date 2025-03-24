**Why code in C?**

	If we were to code in assembly language then we will have direct control of the processor which can be dangerous as we may do something we may want to and we may hold to much power when it is not neccessary. C deals with this whilst maintaining performance

	If we were to code in Java we have to make a lot of assumptions, so has to do a lot of potentially unneccesary checks, it runs in the JVM which is a virtual machine which adds in complexity and we will have less control over memory and how instructions operate. C fixes this by giving more the programmer more explicit control, and runs on raw hardware rather then a virtual machine.

	Many aspects of Java programming language builds on C, some keywords are similar/same but not all.

**C data types**

	Only 4 primitive data types in C:
		char 
		int
		float
		double

	We can modify some integers to access the following data types:
		short
		long 
		unsigned
		signed

	C doesn't have boolean types, however the library <stdbool.h> can make booleans available.

**C classes and objects

	C does not have objects o r classes, but sometimes we awnt to link data together so we can have a object/class system in C called "struct", it cannot contain any functions and only variables and everything is public in a "struct"

![[Pasted image 20231026104124.png]]

**C conditionals

	Rather then checking for true as there are no booleans in C, they look for a value that is not equal to 0

**C loops**

	For loops must not have any variables initalized inside the for loop 

![[Pasted image 20231026104523.png]]

**C pointers**

	Pointers are a reference to a memory location which are denoated with a *

	int * is a pointer to a location in memory, where the value is treasted as an integer therefore we look in the address pointed to by the variable and we can get the address of a variable using "&"
	
![[Pasted image 20231026104847.png]]

