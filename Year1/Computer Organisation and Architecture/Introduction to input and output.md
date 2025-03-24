
**Memory mapped inputs**

	We can attach inputs directly to memory cells which is controlled by a switch or any type of input, to ensure that the address is at the correct location we use an address decoder, we then can read the memory to see what is

![[Pasted image 20231107092127.png]]

**Memory mapped outputs**

	We can use a similar techinque to the memory mapped inputs for our memory mapped outputs 

![[Pasted image 20231107092220.png]]

**Memory mapped I/O**

	We can read inputs or write outputs by connecting components to the address bus, we then give each component a memory address, we may need to give each component more then one address depending on the component and how much memory (including registers) it has. The CPU can then read and/or write to the componnet as it would any other piece of memory.

**Advantages of using Memory Mapped I/O

	Very simple to implement
		Don't need a seperate collection of instructions to handle it (an I/O port does)
		CPU requires less internal logic

	We can utilise general purpose memory instructions and any addressing modes the CPU supports

**Disadvantages of using Memory Mapped I/O**

	We have to reserve a portion of memory for I/O components

	If we have a smaller word space, such as a 16 or 32 bit processor, we have less main memory we can utilise, to counter-act this we use 64 bit processors to allow higher word spaces

**What is a Direct Memory Access**

	DMA allows us to tackle the problem that all data has to go through the CPU, as it may introduce a bottleneck as the CPU is really fast relative to other components so the CPU time for the memory introduces a bottleneck as it is too fast

![[Pasted image 20231107093030.png]]

	DMA acts a co-processor, (2nd CPU) that deals with I/O tracking

**DMA description**

	DMA is useful when large amounts of data needs to be transferred, such as a hard-drive which holds a lot of memory. One example is by downloading and managing large files in a PS5 as they have a custom-made DMA controller

	CPU gives control to the DMA controller (DMAC) when it comes to I/O tracking
		DMAC is optimised just to transfer data
		When required, the DMAC can control all the busses on the system

	DMA-based I/O can be 10x faster than a CPU-based 1/O as it is specalised on I/O tracking

**DMA operation/overview**

![[Pasted image 20231107093713.png]]

	1) I/O sends a request to the DMAC
	2) DMAC sends request to a CPU, the request will make the CPU not being able to access the busses and give all control the DMAC to satisfy this request
	3) CPU initalises DMAC such as whether or not it is I or O and etc
	4) DMAC requests use of busses
	5) CPU sends DMA Acknowledge when eady to surrender busses
	6) DMAC sends Acknowledge to I/O to transfer data

**DMA operation organization**

**Detached DMA**

![[Pasted image 20231107094704.png]]

	All components share the same bus, which makes it faster
	The DMAC acts like a CPU, exhanging data between I/O and memory via the DMAC
	Straightforward to implement
	Can be inefficient as 2 bus cycles required per word

**Integrated DMA**

![[Pasted image 20231107094721.png]]

	Similar to detached DMA but..
	Multiple DMACs, each controls one or more I/O devices
	Similarly straightforward to implement
	More communication required between the CPU and DMACs
	Can still be inefficient

**DMA I/O bus**

![[Pasted image 20231107094906.png]]

	Why have multiple DMACs when we can have one connected to all I/O components, ALL I/O devices will have a common bus which is seperate from the system bus, this means that the DMAC only has to transfer data to and from main memory which leads to faster and easier transfers. However this is much more 
	complex to design and requires more hardware

**DMA operation modes**

	DMA can make requests in different ways by using the following modes

**Cycle Stealing Mode**

	DMAC uses the system busses when free
	
	Usually "grabbed" when the CPU is not accessing memory
	
	However the DMAC must be careful as it may mis-detect a clear bus which may be actually a bus that is being used by the CPU

	Another problem is that two DMAC's may steal one bus as they may find an empty bus at the same time
	

**Burst Mode**

	DMAC requests use of the system busses for a period of time

	"Locks" the CPU out of the system busses
		For the requested period of time
		Until the data transfer has been completed

	The CPU can override the lock if needed