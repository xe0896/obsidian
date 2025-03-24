**How to add two binary numbers in base 2

	Can be seen as a XOR gate for addition and AND gate to carry kbits

![[Pasted image 20231017091324.png]] 

**1 bit full adder

![[Pasted image 20231017091546.png]]

**N-bit full adder

	Instead of having 1 full adder to perform one calculation we can have multiple full adders.

![[Pasted image 20231017091733.png]]

![](https://gyazo.com/ce489f2ac0ad687ecefb3383fd680f7a.png)  

**How to do subtraction in full adder (N-bit)

![[Pasted image 20231017092135.png]]


**How to make a number negative using gates

	We invert all the bits and add 1, XOR gates achieve this by taking an input of 1 to mean subtraction or takes in the input 0 if it is addition this can be seen in the diagram above

**Addressing

	When using our processor we will need to access data, we need to translate an address to a memory location where address is a value used to store where the data is located.

	It is usually stored in hex as the addresses are large numbers

**What is a decoder

	Decodes a memory address which will lead to a particular line to be executed where X are memory addresses and Y are lines, it takes the format nxm where n is the adddresses and m is the lines to be executed

![[Pasted image 20231017092643.png]]

**What is an encoder

	We take inputs of Y and outputs of memory addresses X, it also takes the format mxn

![[Pasted image 20231017092732.png]]

	Only one input can be active at a time.

**Active high and active low

	For Yn we always assumed it was 1 (except for one situation) which makes it an active low, therefore we can have the inverse of Yn which will be assumed to be 0.

![[Pasted image 20231017093126.png]]

**Multiplexers (MUX)

	This is an extension to decoders, instead of taking encoders and decoders it can take any inputs and outputs.

![[Pasted image 20231017093324.png]]

	We use "-" instead of "x" where "x" is used by encoders and decoders.
	Different applications for the MUX include parallel to serial convertors.

**De-Multiplexer (DE-MUX)

	Where there are one inputs and four outputs, and takes the same "-" notation.

![[Pasted image 20231017093516.png]]

	Applications for de-multiplexers are control for multiple lights and serial to parallel converter.

	X is represents cases

