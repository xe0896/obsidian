**Arrays

	Arrays allow lists of data of the same type to be stored, the data storage is neat as the list has a single variable name and it is very efficient to access as they are accessed by indexes, which are the position of hte list.

	To declare an array like we done with the variables:

	[type] variableName;

	For arrays we do:

	[type] [] variableName;

	For example:

	int[] numbers;

**Multidimensional arrays

	For 2D arrays we can add more brackets after [type] which makes it into a 2D array:

	int [][] variableName;

	When making two arrays we must do:

	int [] a, b, c[]

	c will be a 2D array while a and b will be a 1D array

**Creating an array

	When we declare an array the value must be iniitalised to the special value null, this means that Java knows that we want some contiguous memory to store some values.

	Arrays spaces are fixed so we cannot increase its size after its initalisiation

	Memory in Java must be allocated with the new keyword, new reserves contiguous block of memory.

	So if we wanted to create an array and reserve some memory for its value.

	[type] [] variableName = new [type] [size];
	int [] arrayOfInts = new int[5]

**Using arrays

	To access a value from the array we must use its index by using the notation

	arrayOfInts[0]

	This returns the first element of the arrayOfInts

**Few rules of using an array

	When making an array the default values are set to null, this is similar behaviour numerical values are set to zero and booolean values are set to false when they are first created.


**Array properties

	Arrays are kind of like objects the thing that seperates objects from primitives is that objects has methods and properties, arrays only have one property which is to see how many items are inside the array.

	System.out.println(arrayOfDoubles.length);

	Using the .length propetty is more maintainable and sustainable as it is going to be suitable for any array length

**Creating multi-dimensional arrays

	