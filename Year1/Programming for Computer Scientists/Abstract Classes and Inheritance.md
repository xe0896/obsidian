
**What are abstract classes**

	The subclass from the superclass becomes more specific then its parent class, as we become more specific this causes the parents to become less specific which eventually they become so general that they become abstract, we call these most general classes abtracstract classes. 

	Abstract classes are special as we cannot make an instance of an abstract class

	They allow us to capture common properties behaviours at an abstract level

	They can contain a mix of abstract methods, which are methods that are not imeplemented

**An example of an abstract class**

![[Pasted image 20231116092334.png]]

	First bubble shows the common attributes and properties to all felines, the second bubble show the methods that are used to access the private variables. The last 3 bubbles are methods that uses instances of to see which subclasses of Feline to return (if at all), the abstract method ends with a semi-colon as it is not really a method.

**How to make an instance of the Feline class**

	Normally we should be able to just:

	Feline f = new Feline();

	Java will give a compiler error that states that abstract; cannot be instantiated

	In order to make an instance of the Feline class we must create a concrete class that extends the abstract class, first we extened then we must implement our previous features as seen below:

![[Pasted image 20231116092523.png]]

**Abstract functions**

	Abstract classes can extend abstract classes, if an abstract class is extended then the subclass doesn't need to implement alll the abstract methods if it is abstract itself.

**Interfaces**

	Once we keep on going down the abstract class we will end up in a situation where abstract classes contain only abstract methods, the lass is now simply describing the interface each inmplementing class should use, for these kinds of classes we call them interfaces. Interfaces are defined like a class but uses the interfaace keyword

	public interface Test {}

	Interfaces can only contain methods and the methods cannot be implemented, but as it is an interface they shouldn't be declared as abstract.

	Subclasses of interfaces do not extend the interface, they implement instead as seen below:

![[Pasted image 20231116093402.png]]

**Multiple inheritance**

	Can we have a class that is an extension of multiple superclasses? In Java this is not possible, all subclasses in Java can only extend one superclass.

**Multiple interfaces**

	You can implemetn multiple interfaces as sthey do not contain implementations meaning there will be no confusion when calling a method, implementing each interface just means that we have to implement the method in the superclass, so there's no confusion.

	The reason we bother with this is because abstract class are good for providing partial implementations, interfaces are usually used to encapsulate a small subset of functionality.

	Multiple interfaces example can be seen below:

![[Pasted image 20231116094907.png]]





