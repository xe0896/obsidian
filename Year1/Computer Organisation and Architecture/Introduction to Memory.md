**Storing stuff

	We want unlimited, fast memory for free, this doesn't exist so we have to compromise on something and to solve this we have to have a memory hierarchy.

	We must consider the cost and also the read and write time of the memory.

**Choosing the right type of memory

	We need to consider the following things:

	- Frequency of access, does the data need to be read/written often
	- Access time, how long does it take to read/write data
	- Capacity, how much data do we require
	- Cost (often per bite/byte), how much will a certain amount cost us

**The memory hierarchy

![[Pasted image 20231031092002.png]]

	Main store = RAM

**Semiconductors Memory Types

![[Pasted image 20231031092843.png]]

**Moore's Law

	Moore's dead law states that for a given size of a chip, the number of components double every year, this applies to both processor components and memory.

![[Pasted image 20231031093133.png]]

**Registers

	There are a very limited number of registers in a processor (often less than a kilobyte) and it is built into the circuitry of the processor

	Extremely fast, as it is extremely close to the components required and it is transparent to the programmer as it adds too much complexity

**Cache

	They are a fast main block of fast memory and store recently used data and is located closely to the CPU

	Most modern processors have 3 levels of cache (L1, L2 and L3) some may have 4 or more levels

![[Pasted image 20231031093447.png]]

	To find a piece of a data it checks in the following sequence:

	L1 cache -> L2 cache -> L3 cache -> Main memory -> Disk

	L1 cache stores in KB and L2, L3 stores in MB

	This is transparent to the programmer 

**Cache reading and writing

	Reading data -> no changes, so don't have to update main memory
	Writing data -> we need a way to make sure that the data is consistent
		Write Through -> update cache and all the all copies in lower levels of the memory hierarchy
		Write Back -> update the cache copy, replace blocks in lower levels of the memory hierarchy when placed.

**Cache hit and misses

	Cache misses often fit into 4 main categories:

	Compulsory -> misses that would always occur no matter how big our cache is
	Capacity -> misses that occur becaues there is not enough space
	Conflict -> misses hat occur because of the placement strategy
	Coherency -> misses that occur because the data was updated by a different processor, so the cache has to be flused. This is more previlant in multi-core processing meaning if one processor is updating the other processor must also updates it cache.

	We can calculate the hit rate (h) as:

$$h = \frac{Number of times the words are in cache}{Total number of memory references}$$

	The miss rate is 1-h (inverse)

	We can't use the hit rate to analyse performance as it doesn't factor in the cost of missing data

	Average memory access time takes into account

![[Pasted image 20231031094743.png]]

![[Pasted image 20231031094809.png]]

**Main memory

	Cache is limited by the size of the processor die, cache can only store a few MB. We need a memory that can store large amounts of data.

	We need it to be faster than hard drives
	We need it to be an order of magnitude higher then cache 

![[Pasted image 20231031094928.png]]

**Main memory -> Dynamic RAM -> DRAM

![[Pasted image 20231031095011.png]]

	Stores the data as charge in a capacitor
		Discharges over time -> needs to be refershed periodically
		Therefore, presence or absence of a charge represents a 0 or 1.
		
	Write -> Voltage applied to Bit Line
	
	Read process is more complex:
		Sense amplifier detects if 1 or 0, which discharges capacitor
		Capacitor is restored and refreshed to original state

	DRAM is a lot cheaper then SRAM
	SRAM often has better read/write times than DRAM
	DRAM often used for main memory
