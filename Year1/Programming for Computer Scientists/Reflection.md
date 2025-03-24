**What is reflection**

	Reflection is a poerful tool that allows us to explore a class at run time

**What does reflection allow us to do**

	We can access the following things about a class such as its:
		Name
		Constructors
		Methods
		Class fields

**Why is reflection useful?**

	While reflection is useful at runtime, it can be also for testing and analysis, we may even find out about constructors or methods that were not lised. This gives us more knowledge and may let us improve our approach in the code.

**How to step through a reflection class usage**

	First we import the reflections library, we then use the "Class" class that we are looking for and attach it to the variable example. We then create an array which will store the classes method. 

![[Pasted image 20231124092724.png]]

	We can also do this to get the classes variables / class fields in the class by using the same logic as above.

**What is the point of this**

	Reflective classes are useful research and testing, less useful for actually performing tasks in code

**Invoking methods**

	When using the reflective vlass we just g et the names of the methods/variables but we cannot execute them, however with the use of invoking methods we can execute the method.

![[Pasted image 20231124093935.png]]

