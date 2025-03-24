**Classes**

	When working with objects we will have to create a blueprint of the object, an object is a specific instance of this blueprint. The blueprint just describes how we create objects

	In Java, we call these blueprints "Classes"

**Rules and conventions of a class

	- public classes must be in their own file
	- the convention is that class names begin with a capital letters

**Example of a class**

![[Pasted image 20231102093136.png]]

**Alternative thinking**

	Programming in OOP is just an alterantive way of thinking problems, it is a way of organising your code so that the data and the
	
  operations on that data are bundled together.

	Object types are just extended types as we can declare them similar to integers such as int radius

**How to run a class using constructor methods**

	A constructor method is a a special method that
		- has no return type (not even void)
		- has the same name as the class

	It's purpose is to set up the object according to some rules

![[Pasted image 20231102094008.png]]

	this.radius = radius is allowed as we can method variables with the same name as class variables, however if we want to refer to the class variable, we must prefix it with "this."

**Creating objects**

	With arrays, the new keyword just reserves enough memory and sets default values

	With objects, the new keyword reserves enough memory and also calls the constructor function we just wrote

	The syntax is similar as for errays

![[Pasted image 20231102094325.png]]

	You don't have to write a constructor, if you choose not to Java will create a default constructor

	But the default constructor does not set any values so the objects will do nothing until you start interacting with it

**The point class**

**Object comparisons**

	As == is only for primitive data types not for objects, to see if they are the same we can use a special method called equals() which returns a true or false value if the two objects given are the same

**Access modifiers

	public - can be accessed outside the class and call the methods
	private - can only be accessed inside the class it was declared in (where its scope exists)
 
	Why would does this matter? Some data we want to restrict access to as some values may be confidential and can only be accessed by certain people
	We also want to maintain a good interface between programmers

**Constructor methods accessability

	We need constructor methods to be public or else we cannot create instances of objects

	If we don't specifcy an access modifier, all methods (including constructor methods) are package-private 

**Private variables

	We usually make our state variables private as it makes them not accessibile by users as it is likely to be confidential or having access to the variables will break how the system works

**Encapsulation**

	Making data private and some methods public is known as data -hiding, encapsulation doesn't mean data-hiding but it leads to it.

	Users are then driven to use a clases by its external interface

	The implementation nof the class can be done in whatever way the programmar wants, the external functionality will remain the same

![[Pasted image 20231103093034.png]]

**What is the purpose of encapsulation**

	- The boundaries of responsibility are clear
	- The unnecessary detail is hidden
	- The implementation can change without ruining dependant applications

**Setters and getters with consideration of encapsulation

	When using data-hiding you will often want to access the instance variables

	For the point class we write a setX(int x) and getX() method

	The advantage of this is that boundaries can be set on how high the x value may be as it may not be able to exceed 50

**Interfaces**

	The interface is your link into someone's code, the public properties and methods in your code define the interface that others can use

**Instance variables**

	Is when a variable is tied to an instance meaning that the variable is tied to that object

	We can make a variable shared between instances of a class, this is where the static keyword comes in allowing the variable to be global essentially in terms of classes

**Examples of static methods and variables

	Math.PI is a static variable as it has a strict value

	Math.round(x) is a static method 

	static keyword is used when the functionaility is not changed if there is a different input

**Visualization on how data works in classes**

![[Pasted image 20231103095415.png]]



