**Fundamentals of a processor

	A CPU is made with a number of different components and there are a numbre of idfferent components.

	- Arithmetic and Logic Unit (ALU), performs mathematical and logical operaitons, it takes in two inputs and outputs ..
	- Control unit (CU), decodes program instructions they allow to translate machine code to hardware signals for the hardware to understand.

**Running instructions

	To run an instruction, we need to:
	1) Get the current instruction frmo memory
	2) Decode the retrieved instruction and establish any parameters
	4) The control unit sends signals to allow the CPU to function and change the data registers, ALU, memory...

	This is known as the fetch-decode-execute cycle. 

**How does this link to assembly

	Assembly is dependent on the arhictecture and different processors are organised in different ways

**Language architecture

![[Pasted image 20231024091800.png]]

**What is RTL

	Register Transfer Language (RTL), this is used to describe operations within a microprocessor
	Main memory is represented as MS(<location>)
	
		Example -> contents at 12345 would be MS(12345)
		
	We can transfer contents from one register to another as [<to location>] <- [<from location>]
	
		Example -> transfer Program Counter to Memory Address Register would be [MAR] <- [PC]

	This is not assembly language, this is like pseudo-code.

**RTL when instruction fetching

	D0 = register

	RTL is powerful enough to represent a simple fetch-decode-execute cycle:

	1) [MAR] <- [PC] - Stores the current program counter in the MAR 
	2) [PC] <- [PC] + 1 - Increments the program counter, ready for the next cycle
	3) [MBR] <- [MS([MAR])] - Gets ther equired instruction from external memory and store this in the MBR
	4) [IR] <- [MBR] - Transfer the MBR to the instruction reigster
	5) [CU] <- [IR(opcode)] - Use the stored instruction in the instruction register and decode it using the control unit

	The actual instruction is the opcode itself.

**RTL when fetching and executing

	The fetch sequence is the same as above but with additional steps to satisfy the execute.

	6) [MAR] <- [PC] - Store the current Program Counter in the MAR
	7) [PC] <- [PC] + 1 - Increment the program counter
	8) [MBR] <- [MS([MAR])] -Get the required data from external memory and store this in the MBR
	9) [ALU] <- [MBR] + [D0] - Adds the data retrieved from memory to d0 in an ALU
	10) [D0] <- [ALU] - Store the result from the ALU in D0

	This instructions adds a constant to the byte D0.

**What is RISC-V

	RISC-V is a processor that has a small instruction set but can do a large amount of tasks

	RISC-V does not specify a large amount of hardware

![[Pasted image 20231024093301.png]]

	RISC-V only requests 32 registers
		Register names start with an x followed by the number
		Each register has 2 names, depending on their recommended use.
		
	RISC-V requires x0 is always 0

	Register for condition and status
	Register for program counter

**RISC-V instruction set

	RISC-V has 6 formats for instructions

![[Pasted image 20231024093611.png]]

	Each instruction has an easier format, so  you don't have to code in machine code.

![[Pasted image 20231024093836.png]]


**Assembly language

	Microprocessors interpret specific binary sequences as instructions

	Machine code can be written in binary, often written in hex butthis is very hard to read and write

	Assembly makes this more human readable, they are architecture specific, but often have the following format

![[Pasted image 20231024094104.png]]

	Label: Opcode: Operand(s) # Comment

	Example:
	START:
	ADDI x3, x2, x1 #x3 = x2 + x1

**Assembly Language Example

![[Pasted image 20231024094208.png]]

![[Pasted image 20231024094334.png]]
![[Pasted image 20231024094352.png]]
![[Pasted image 20231024094559.png]]

	Always uses relative addresses -> minimises risk of clashes with other programs
	Base sepcification only deals with 32-bit integers
	RISC-V has a collection of extensions that can be included if it is required:

![[Pasted image 20231024094713.png]]

**Different RISC-V Instructions

![[Pasted image 20231024094740.png]]

	1) Arihmetic, responsible for the addition and subtraction logic
	
![[Pasted image 20231024095047.png]]

	2) Use of logic gates such as AND, OR, XOR

![[Pasted image 20231024095119.png]]

	3) Shifts is responsible for the divide and multiplication of binary numbers

![[Pasted image 20231024095149.png]]

	4) A suitable if statement in assembly langauge

![[Pasted image 20231024095223.png]]

	5) Similar to branches but there is nothing to compare so it jumps to a line or address regardless

![[Pasted image 20231024095313.png]]

	6) Sets a bit in the a register if one register

![[Pasted image 20231024095358.png]]

	7) Memory has two sets of instructions, loads and stores.

![[Pasted image 20231024095455.png]]

	8) System control allows to control the system

![[Pasted image 20231024095544.png]]
