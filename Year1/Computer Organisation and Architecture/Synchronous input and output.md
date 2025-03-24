

**Why do we need to sync?**

	I/O devices are often always slower than our processor
		What if the device isn't ready for the processor to read its data
		What if the device isn't ready to accept new data from the procesor

	Printers are a good example of this, it takes a relatively long time to print a character, you normally have to wait until a character has been printed onto the page until we can send the next piece of data.

**Polling**

	Polling is when the processor is constantly asked, are you done yet?/ready?, if it is ready then the signal continues as normal

	If it is not ready it may ask constantly until it is ready, and another way of polling is to use the same principles as last time but we do something while waiting.

![[Pasted image 20231109101712.png]]

**Polling advantages and disadvantages of using polling**

	The advantages are that is it very simple to implement and to build it into to hardware, and we only have to check a singular bit constantly as a 0 or 1 can be represented as ready or not, we can use a while loop to keep checking the required data

	The disadvantages are that it wastes CPU time and power, therefore if you have a battery powered device, using polling will constantly check to see if the status is ready, if it is not it will constantly loop back which could take a while which means that the battery will be eaten quickly. It is also not great if you ened to do a lot of other things as the polling can take a large amount of time and wastes time for other processes

	Interleaved polling will lead to delayed responses as as it is doing something else then the feedback will be delayed, and that would not be good for difficult real-time situations such as an airport that needs constant feedback

**Handshaking**

	Handshaking is when the I/O device says when it is ready and the processor says when it is sending valid data, and it iused to coordinate CPU and I/O devices to synchronise the transfer of data.

![[Pasted image 20231109102408.png]]

**Handshaking timing diagram**

	When the I/O device is ready the VALID line will be turned into 0 which means that data can be sent, this leads to data to be sent until the READY line says something different, until we get to the point where the printer cannot accept any more data, this leads to the transaction to be paused. This carries on

![[Pasted image 20231109102631.png]]


**Handshaking 6522 VIA**

	We can do the handshasking in software, this makes it easier to use sepcialised hardware as there is less insstructions

![[Pasted image 20231109103325.png]]

**How to setup handshaking with 6552 VIA**

**Interrupts**

	When the I/O device is ready instead of constantly checking the I/O device itself tells the CPU that it is need of the CPU's time, there are some times interrupts that are classified as an NMI (Non-Maskable Interrupt), this is to say that there is an intterupt that cannot be disabled/masket out which usually means that this interrupt is of high priority.

**Interrupt sequences**

	When an interrupt response is given, the CPU completes its current instruction then it will push the program counter onto a stack and push the registers onto a stack, then it loads the program counter with the address of the interrupt handler, this then means that the interrupt code runs. When the interrupt code finishes then it will pop the program counter from the stack and pop the registers back into the CPU from the stack.

	Interrupts can also nest

**Interrupts advantages and disadvantages

	The advantages of interupts are that is has fast response times as it only act when we need to, also no wasted CPU time or power as we dont have to constantly check and we only do stuff with I/O when there is something to be done which is very important if we are using battery power

	The disadvantages of interrupts is that everything is still controlled by the processor which means that if there is something important how would we priortise the important interrupt since there is no way to filter out the non-important interrupts. There is also much more complex hardware and software as we need to handle putting things on and taking things off the stack can be complex.