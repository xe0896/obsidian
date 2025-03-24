	
**Program skeleton

	A empty class that has a purpose of //P which is required for mainly every program in Java:

	![[Pasted image 20231006091509.png]]

**Understanding the specification

	Precondition
	Input
	Calculates
	Output
	Postcondition

**Storing values in Java

	Variables are declared by giving a type then the name for example:
		[type] name;
		OR
		int a;

	Before we can use a variable it must be given a value for example continuing the example from above:
		a = 5;

**How to receive an input in Java

	Using a scanner class by making the name sinput is being used as a scanner object which is some template allowing input from the user, this then allows us to use sinput.nextInt() where nextInt() is a method which checks to see if the value is an integer or not 

	![[Pasted image 20231006091933.png]]

	This then allows the actual input to be received from the user in the code below by adding a guranteed message that says enter the first number and the item that is input by the users keyboard is given the value a due to the sinput scanner object calling the method nextint()and it must be an integer due to nextInt() method.
	
	![[Pasted image 20231006092043.png]]

	This makes the code perform four functions:
		Declares an integer variable called "a"
		Prompts the user for some input
		Reads an integer from the input which is usually a keyboard
		Stores a value in the variable "a"

**Output in Java

	When receiving input from the user we use System.in(SCANNER METHOD) but when outputting in Java we use System.out or System.err

	When doing System.err we use it to utput errors whereas System.out we use it to print anything else out such as a variable the user wants.

**Concatenation in Java

	The way we concatenate in Java is that we use +, we only really concatenate strings so:

	System.out.println("Hello" + a)

	Where "a" is a string

**Integers in Java

	When using data type like int we must ensure that it fits within the range between -2,147,483,648 and +2,147,483,648. If we ignore this detail then errors occur as the range is not satisfied as the value may be higher or lower then the values stated.

**Number systems in Java

	Negative numbers in binary are stored in two complements which causes the range for int to be large as it also considers the negative number

	There are many different data types to store integers, this is used if the number satisfies a particular range:

	![[Pasted image 20231006092616.png]]

**Calculation of GCD (INCLUDE SCREENSHOTS)

	Steps:
		1) Check if a and b are equal using an equality operator, this can be checked using the not equals operator (!=) 
		2) If a and b are equal then we can print either one and stop, if not then we must repeat an ACTION until they are, this can be done via a while loop
		3) To execute the action we must make the larger integer (a or b) to be minused from the other integer so if a > b then a = a - b, else b = b - a. This is repeated until 2) is correct
		4) To print we can print the GCD with a new line using System.out.println(a); before doing System.out.print("The GCD is:"); to make the user know what is being printed out after the text ("The GCD i.."")

**Primitive data types

	Other then the 4 data types (byte, short, int and long) we use another 4 that we refer as primitive.

	The two floating point types in Java are float and double:
		A float is 32-bits which can be represented between -3.4e38 and 3.4e38 with 6 to 7 of digits of accuracy
		A double is 64-bits which can be represented between -1.7e308 and 1.7e308

**Floating point notation

	Floating point numbers are stored in a specific form and is a bit DUMBY

	![[Pasted image 20231008203523.png]]

	The offset which is 127 is calculated by the formula: 

$$2^{k-1} -1 $$

	where k is the number of bits in the exponents which there are 8 bits. The offset is there to allow us to have negative exponents.

**Precision

	For an example if we wanted to calculate the area of a circle and make the variable area declared as an integer and store the value in the variable area the calculation will lead to an error as the area will not be an integer but we are trying to make an integer be a double which is not possible. To counteract this we must change the data type which is called an implicit cast as seen below.


	![[Pasted image 20231006094521.png]]


	For primitive types going from a floating point value to an integer value will cause data to be lost for example the integer value 44000 is stored as 0...10101111100000, but when casting it to an 8 bit type we will be left with 11100000 which is -32 which is different then 440000, this means we must cast with the correct bit value

	This is the hierarchy which goes from post precise to least precise.

	![[Pasted image 20231006094918.png]]

**Boolean notation in Java

	For AND we use &&, for example A && B = 1 if A and B are 1, else = 0
	For OR we use ||, for example A || B = 1 if atleast either A or B are 1, else 0 if both are 0
	For XOR we use ^, for example A ^ B = 1, if A and B are not both 0 or 1, only if they are different from one another
	For NOT we use !, for example !A = 1, if A = 0 it does a negation of the input

**What is the difference between lazy and strict operators

	Lazy operators are when there are two symbols for the boolean operator such as && instead of &, && is a lazy operator meaning that if there was a statement such as:

	b = 5
	a = false
	if a %% b ++  == 5{...}

	Then "a" will not be incremented due to the lazy operator which sees that a is already false in the statement meaning that it output false straight away which skips over the fact that a must be incremented by the "++" operator.

**Short-hands

	+=, -=, *=, /=, ++, --

**Order of precedence in Java

	(PUMARESULA)
	Postfix: --expr or ++expr
	Unary: expr-- or expr++ 
	Multiplicative: */%
	Addictive: + -
	Shift: << >> >>>
	Relational: <> <= >=
	Equality: == !=
	Strict operators: & | ^
	Lazy operators: && ||
	Assignment: = += -= *= /=
