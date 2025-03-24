
**Organization vs Architecture**

	When looking at an organisation you look at the inputs how its made, whereas the architecture is how it works and you don't really bother how it was made.

	Software Engineers normally work on how they work whereas hardware engineers work on how they are made

**Common components of a processor**

	All processors will need some sort of memory which is normally called registers to store data, which are called D, whereas registers which store addresses are called A.

	We need a bus that allows all the components in the CPU to be connected to move data and move addresses easily

	We need something that keeps track on where we are in our program which is known as the program counter

	We need something that stores out registers itself which stores what instruction we are about to compute and what data that is attachted to it such as its address or its immediate value which is called the instruction register

	We need something that is able to interpret our instruction which is called a control unit, this takes our IR as an input and decodes and understand what it is which does the decode part of our FDE cycle

	Finally we have our ALU which performs our computational logic which holds our AND, OR, XOR

**Control unit**

	The primary purpose is the decode and execute the instruction present in the instruction register, and it may take control signals as inputs.

	The data in the IR consists of two parts:
		The opcode (instruction)
		The operand (the parameter)

![[Pasted image 20231114093014.png]]

	The opcode is what really matters as it controls what will happen, this leads for the contorl unit to contain a bus specially for the opcode.

	We also have a master clock which allows for quick clock accesses, which controls the pseed of how we decode and execute instructions

	We also have flags from the CCR (conditional registers), sometimes we need to know if something is not 0 in the ALU or less then another thing in the ALU, this leads to the conditions of the previosu execution whuch is stored in the CCR which then can be used later on, this is usedful for the branching statement as we may want to see if the previous isntruction was 0 which leads to the data being stored here

	An enable and a clock line for each component which we may need to control whether we want to disconnect or connect to allow inputs and outputs

	We can have a read/write line for memory which can give out the input of what was used to input for the CU

	We also have function lines for the ALU and allow for computation with our bits

**ALU**

![[Pasted image 20231114093753.png]]

	The ALU performs mathematical and logical calculations, this leads to the input of 2 connections of registers (P,Q) and function lines (F1,F2) which determines what action the ALU needs to be

	For our output we need a regsiter as our output (F)

	We need to see what happens in the ALU which gives tells us if there is an overflow in the CCR

**Turing complete**

	Something is considered of turing complete when it is able to solve any computational problem where it ignores runtime, memory, power. It means that in theory as long as we have a way to express in turing completeness we can express this in any machine

	This involves using conditional loops or conditional jumps such as for loops and branching statements, this is known as turing complete functions.

	It also must be able to read data from and write data to storage to be considered turing complete

**Turing complete examples**

	Every programming language is turing complete as they all do the same functionality

	We can have turing completeness with a single instruction, an example of this is called Subleq which subtract and branch if less than or equal to something

![[Pasted image 20231114094127.png]]

**Micro and macro instructions**

	Because we have minmal instructions we can define micro and macro instructions

**Representation of instructions**

	In assembly the instruction ADD #42 D0 will add 42 to D0, when in machine code we have the questions what does it look like, where do we store "42" and "D0" and how does the processor know that a specific set of 1's and 0's is an add command?

**Add -> Micro instructions**

	We can represent high level (macro) functionality of this using RTL, we can represent this using macro RTL

![[Pasted image 20231114094419.png]]

	And we can also represent this at a lower (micro) level:

![[Pasted image 20231114094450.png]]

	Both of these are allowed and represent the same instruction but using two different levels macro and micro.

	Some instructions cannot be executed at the same time, so we need multiple clock cycles meaning we can do some steps independently from each other which is seen in steps 1, 2 and 3. This shows how we can do things in parallel to eachother and we can do some instructions using one line instead of multiple

**Signal timing assumptions**

	Things we have assumed is that everything is instant when in reality timing diagrams are designed to show how many clock pulses are required and potential propgation delays, and we also discussed the execute part of the FDE when in reality each part would require a number of clock cycles and we also have assumed that there is a set of registers in the ALU whereas in reality this would have to be specified which affects the timing diagrams.

**Control signals**

**CU design**

	We have seen that each instruction whether ir be miecro or macro may require multiple clock cycles to execute fully, if there was less clock cycles per instruction then it would be considered a faster processor as we are doing more at a less time. If we were to have a faster clock then the faster the instructions are executed which means that it gives us a faster processor

	When designing we want to minimise the number of instructions given which allows us to increase our less clock cycles per instruction as there is less instructions.


**CU design overview**

	We have two levels of how we design the control unit

**Hardware**

	We can design the CU using logic circuits, boolean logic transforms niputs into specific outputs, sometimes this is called random logic as it can be seen a bit much and random

**Microprogrammed**

	Each machine instruction is mapped to a micro instruction, this leads to all the mappings stored in the ROM are called microprogram memory which is sometimes called "mu" program

**CU design using hardware**

	In order to build the CU in hardware we need a new piece of digital logic, this gives us the consideration of a sequencer which activates a line per clock cycle in a round robin fashion which is when a time slice is given to each process

	The sequencer tells us how far through a particular instruction we are


![[Pasted image 20231114095415.png]]


**CU design hardware example**

	We need an opcode to see what instruction we have, this is given to the decoder, we need a clock that will allow us to control our control unit and we have a CSG we contorls what our pins in a different lines, each line of our decoder lines are given to the random logic chip, which gives us our usual outputs. We need something we are fetching or executing an instruction which is stored in a flip flop. We connect to enable lines in our random logic and our decoder so we can turn on our decoder whether we are in our decode stage or execute stage. We need something what instruction we need to run which the sequencer handles twhich si connected directly to our clock line which constantly tells us what microprocessoir is run, when we our finished with our executing instruction we start) fetch to 1 when we are at the end of our fetch instruction we set execute to 1. This is connected to a flip flop to flip between the two. When we fnish our execute or fetch we restart our sequencer which is controlled by the logic gate OR.

**CU design advantages an disadvantages**

	Advantages are that it is very fast and often incredibly power efficient, however the disadvantages is that it is very complex and difficult to design and test. Furthermore it is inflexible which means that it is difficult to change and issue be found or a new instruction needs to be added.

**CU design microprogrammed

	The design stage of the internal logic of the CU is difficult especially when updates need to be made, often different macro isntructions will share micro instructions. What if we had a mini-program with mini-functions for each macro instruction.

**CU microprogrammed terminology**

$\mu$ - greek letter "mu" represents micro

Microaddress - A location within $\mu$program memory
Microinstruction - Holds the CU output values as well as other fields required for control flow of the $\mu$program
MicroPC - The CU's internal program counter
MicroIR - The CU's interntal $\mu$instruction register
Microprogram routine - Describes how to generate the 

**CU design microprogrammed example**

	Clock? We then transfer our opcode to look up an address, this is thetn passed down hwhich calculates our microprogram counter, which looks up in memory and iterates the PC sequentially.. This is connected to our program counter to store the value in our program counter., every time we have a clock signal we wanta new program counter. This is then given to two things, one thing is a +1 to increment the program counter, the other bit will be where the memory should find the micro pgoram counter. Once we have our instruction from our microprogram memory this is then stored in our micro instruction register. This then transmits all our data out to the real world.

	We now need to consider how to fetch a new instruction, execute -> fetch. 

	We also may need to jump to the microaddress if there is a situation such as a branch statement

**CU design microprogrammed advantages and disadvantages**

	Advantages is that it is easier to design and implement and can be more flexible as it works with micro isntructions, furthermore it is easier to extend for new instructions and/or bug fixes. However the disadvantages is that because we have to interpret our macro instructions in terms of macro instructions which causes the macro instructions themselves to take longer as they have to go through the program counter and the instruction register. Furthermore each macro instruction will call many micro instructions