**Module Aims:

	Understand the fundamentals of electronic logic and its use in the operation in microprocessors.
	
	Understand the role and operation of the memory hierarchy and input and output mechanisms.
	
	Develop practical experience with digital circuits.

**What did Alan Turing do:

	Developed mechanical machines to help decipher Enigma codes in WW2.

	Developed the idea of "Turing machines" minimal viable computing.

	Worked on the first stored program computers.

**Moore's Law:

	States in 1985 that for a given size of chip the number of components would double every year (Started the company Intel), this law holded true for a while.

**How do we measure performance:

	Teraflops.

**Variation of processors:**

	Embedded systems with limited power both in wattage and computationally.

	Field Progammable Gate Arrays (FPGAs), reprogrammable processors whih takes a long time to compile and map. Is used in networks.

	Graphics Processing Units (GPUs), huge amount of seperate processors each with very limited computational powers.

**Signals:

	The first computers relied on analouge signals:
		Very sensitive to noise.
		Variations in the electronic currents used.

	This moves over to digital logic, mapping electrical currents is needed:
		Allows for more resilience.
		Cheaper to produce.

**Signal graphs:

	The left shows what we represent in simple terms whereas the second graph shows how the actual signal graph works.

![[Pasted image 20231003092019.png]]

	An off and on signal is used to make it easier to know if there is high or low signal, on the right the electrical signals are jaggered due to the unpredictable movement of the electrons making them jaggered.

![[Pasted image 20231003092221.png]]

**Bits, Bytes and Words:

	Signals acn be translated into bits, 0 or 1
		0 (LOW) -> 0V to 0.8V.
		1 (HIGH) -> 2.4V to 5V.

	1 Byte = 8 bits which can represnt 0 to 255.

	Word -> Number of bits that can be processed simultaneously.

	Most significant Bit (MSB) shows us the bit in the word with the highest value.

	Least significant Bit (LSB) shows us the bit in the word with the lowest value.

**Busses:

	Bits can be sent to different components in 2 ways:

		Read using increments of time but it requires synchronisation and is limited to 1 bit at a time and is also expensive to build.
		Multiple cables sending a bit each which is cheap and easy to extend and requires less components.

	The latter is referred to as a bus.

	Word size is usually limited to the size of the bus.

	All required components are connected to the bus.

	Buses are used to make it easier to disconnect and reconnect components.

	Diagram of a bus:

	![[Pasted image 20231003092911.png]]


