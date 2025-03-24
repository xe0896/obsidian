
**What is RISC**

	RISC's aim is to make small number of instructions that covers everything we neeed, this means that it may have to run more instructions in order to do complex operations that may be neccessary. Most RISC processors will have fixed length instructions, they also will often use a hardware based control unit.

**What are RISC's advantages and disadvantages**

	The advantages is that everything is built in hardware, meaning it is more energy efficient and can be faster without increasing clock speeds. However the disadvantages are far more complex to build and far more complex to design and cannot be easily patched or expanded upon.

**What is RISC

	CISC's aim is to combine multiple instructions to make things simpler, does not neccesarily need a fixed-width instruction set as we canh ave instructiosn that cloesr match higher level languages which leads to smaller programs and need less access to memory. This will mean that we will have a lot more instructions and will oftenh ave a microprogram-based control unit.

**CISC x86 architecture**

	x86 has variable length instructions which means that more instructions can be added, and it now includes instructions for parallelism and optimisation.

**What are CISC's advantages and disadvantages**

	The advantages are that it is quick and simple to design and implement, and it is fairly easy to update with new instructions and/or bug fixes. However the disadvantages is that it has to run it at a faster clock speed to get a similar performance to RISC as there are more micro-instructions which requires more time per macro instructions, also due to the multiple instructions that the CISC instruction set has it will require more power to run.

**Multithreading and multicore systems**

**What is a thread**

	A threat is an execution cotext for a processor, including a stream of instructions. Therefore, we can split the computation in a process over multiple threads

**Multithreaded systems**

	Multithreading can be executed on a single core system
		While a thread is waiting for a piece of data from memory or I/O, another thread can take over the processor and execute.
		Changing threads is cheaper to do than changing the process/program

	Each process/program is allowed to spawn as many threads as it wants, it is only bound to the limit of memory in your system

	No time slice for each thread, time slice for processes
		Threads (usually) switch faster than processes.
		Threads can hold all the time which can starve other threads

**Problems with multithreading

	Race conditions
		Thread 1 will do "a write to x" similarily thread 2 will do "b writes to x", both threads are updating the same data at the time, to fix this is to utilise a lock to prevent another thread from updating data

	...

**What is a core**

	A core is a phyiscal processor that can run code indepedently, nearly all the cores will be on the same processing power, in an ideal world you will have one thread per core. Every core will often have a small level of L1 cache

**Multicore systems**

	More cores will mean more work that can be done in parallel per clock pulse, often threads will run independently on each core, we can specify that a program will take all/some of the cores, and how the work will be divided between these cores. However this is limited by the size of the processor, power and thermal dissipation.





