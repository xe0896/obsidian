
**What is inheritance**

	It's a set of properties you get from a parent

	Classes can inherit from a parent class, we call the base classes that we inherit from the "Superclass" and we call the derived classes "Subclasses"

	The subclass inerhits some features (basically all) from its parent class and may have its additional ones of its own

	This is a very important feature of OOP

![[Pasted image 20231110091942.png]]

**Example of inheritance**

	We will try writing a Class for a Lion, we're going to be building upon the cat class. In order to do this we use the "extends" keyword:

	public class Lion extends Cat { }

	We now need to consider what a lion specifically has that differs from a Cat

**What is method overriding**

	We can write a method that is the same as the inherited method, and if we call it on the subclass, it will override the method in the superclass

**What if we wanted to access a private variable in the superclass**

	The "super" keyyword refers to the instance of the superclass, we can call the superclass constructor and relay the constructor parameters

![[Pasted image 20231110092543.png]]

**What are the super() keyword restrictions**

	We must ensure that the first thing is do make the subclass constructor, if you don't do it then the Java compiler will call the default, no-arguement super constructor


**What is the sleep() method

	The sleep() method clearly sets up some kind of sound and light monitors, otherwise how would they wake up when a threat is near, why don't we just are the Lion sleep method call the Cat sleep method twice, we uset he super keyword to refer to the current instances superclass

**What is the protected keyword**

	Subclasses can see protected elements elements of superclasses, so properties such as age, name and legs could be made protected such that we can access them from the Lion class without having to use accessor methods

**What is polymorphism**

	In Java, polymorphism describes its ability to process objects of different types through a single uniform interface

**Examples of static polymorphism**

	if there was a method that added two numbers another method that added 3 numbers, if they were to be both called add() then if I were to do add(1,2,3) then it will automatically go to the method that has 3 parameters instead of the method that has 2 parameters

**Examples of dynamic polymorphism

	This is usually called run-time polymorphism, an example of this can be seen below:

![[Pasted image 20231110094347.png]]

	Java resolves their types at run-time, realising thato ne is a Tiger superclass, the other is a Lion subclass and so calls the correct Lion/Tiger specific methods
