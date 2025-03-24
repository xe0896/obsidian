
**When shall we use don't care cells

	When we make bubbles, if we make bubbles that satisfy 2^n but we have a left over cell, we can ignore that cell (which means that cell is a don't care cell). However this is bad practise as we need to make less bubbles as possible and we generate a larger boolean expression.

![[Pasted image 20231019100834.png]]


**What is computational logic

	Logic circuit which produces an output depending on its inputs only.

**What is sequential logic

	Logic circuit which produces an output depending on its input and the current state

![[Pasted image 20231019101533.png]]

**What is a flip-flop

	A circuit that is able to switch on a pulse.

![[Pasted image 20231020162954.png]]

	The set and reset are active low inputs which are inputs that are not outputs of the other NAND gate.

	Atleast one of either S or R are active high's as if they were both active lows they wont work as seen from the !!!

	Q is the output whereas P in this case is the inverse of Q

	We can visualise the flip flop diagram storing bits in the timing diagram below

![[Pasted image 20231020165130.png]]

	Before t1 the initial input is whateva, but since it is 1 1 then that means there is no change meaning that Q and P will remain the same, when t1 is reached and R goes to 0, in the truth table Q will be 0 and P will be 1 and this is seen in the diagram.

	When t2 is reached and R goes back to 1 , as 1 1 is no change this means that Q and P do not change. 

**What is a D-Type latch

	We can extend the D-Type flip flop to build a 1-bit memory circuit which is called a D-Type latch

![[Pasted image 20231020170829.png]]

	The enable input makes it so no matter what the value of D is, the values of Q (the bit stored) will not change meaning that we can store bits if Enable is 0.

	The output will only change if Enable is high 

	The truth table can be simplified down even further:

![[Pasted image 20231020171816.png]]

**More latches

![[Pasted image 20231020172130.png]]

	Blud did not try to explain any of these

**N-bit registers

	Instead of storing 1 bit only using flip flops we can store N number of bits seen by the diagram below.

![[Pasted image 20231020172702.png]]

	Each D-type is storing one bit and we can have N number of D-types

	This is used by one clock meaning we are storing data in parallel instead of in a series, which may not be very practical in some cases, if we do want to store in a series we can use a N-bit shift register

![[Pasted image 20231020173626.png]]

	If we were to store 1101 we will first input 1 into D which causes the first D-type to store 1 then do a clock pulse, then we input a 0 which causes the 1 from the 1st D-type to go to the 2nd D-type which leaves space for the 1st D-type for our 0 then do another clock pulse then the other two 1s.

	We have to do a clock pulse each time we want to store a new value

**N-bit counter

Idk

**3 state logic

	Our standard logic gates had up to 2 states a high or a low, now we can have 3 states high, low or unconnected, when enable is 1 then the input is connected to the output whereas if the enable is 0 then the input is not connected to the output. This is also known as a 3-state buffer AND the bar above the word "Enable" means it is an active low system.

![[Pasted image 20231020175559.png]]


	We can use 3-state logic to connect and disconnect different components to a bus since we have a 3 state logic gate and can enable and disable what inputs are allowed to be connected to the bus

![[Pasted image 20231020180300.png]]

	Using this we can store N bits seen by the diagram below:

![[Pasted image 20231020180550.png]]

**Theory Vs Physics (physics = real world)

**Propagation and delay

	Logic gates treat a range for "low" and "high" but in the real world they will be a delay of low and high due to the electrons needing to be passed through the circuitry. 

![[Pasted image 20231020182052.png]]

	The picture above shows that the forbidden region shouldn't happen as a high (5V) and a low (0V) is only possible but in the real world it may be reached as there is a time for the electrons, this is called propgation delay

![[Pasted image 20231020182545.png]]

	The gate above should be avoided as the charges may combine or if one is at a high then it may pass this on into the other gate and lead to issues and during the transition period from a high to low or low to high then two signals may be in the forbidden region which may equal to a 1 which causes it to output 1 when we didn't want to.

**Logic Integrated Circuits (ICs)

	We can build small integrated circuits and more complex logic using programmable logic devices.

	- Programmable Array Logic (PAL) -> First popular programmable device, could only be programmable once which was not practical
	- Programmable Logic Array (PLA) -> Contains a collection of AND gates, which feeds into OR gates
	- Field Programmable Gate Array (FPGAs) -> Contains a large collection of gates enough to replicate an entire chip.

**Example of a PLA

![[Pasted image 20231020184252.png]]

	The PLA uses an input buffer to store its input which allows the inputs to have a delay so we can correctly read the correct inputs and outputs.

	Then the input buffer outputs the invert of every input so we can get every combination of inputs that might be required. 

	This is then given to a series of AND gates then the outputs of the AND gates are given to a series of OR gates where the OR gates output are stored in the output buffer since it ensures that the propogation delays are finished before we output something

![[Pasted image 20231020184857.png]]

**How to program PLA's

	We remove some inputs and outputs of the PLA which forms equations

![[Pasted image 20231020185249.png]]

	The bar ontop of X means that is it active low