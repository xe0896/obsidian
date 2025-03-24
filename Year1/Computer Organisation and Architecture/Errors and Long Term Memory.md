**How do errors occur?**

	Often happens when we send data from one to another, which causes noise which is not the noise that you hear but the time it changes to change from a high to a low

![[Pasted image 20231102101110.png]]

**Defining noise

	Noise -> Unwanted information
	Can come from different physical properties such as:
		Thermal Noise
		Noise from electrical components
		Noise from transmission circuits

	Magnetic media also suffers from classic form of noise -> random alignment of magnetic fields

**Parity**

	These are smallm isolated incidences and in can occur randomly

	If probability of an error in the channel is low, then the probability of 2 happening next to each other is even lower

	We can deal with this issue by:
		Sending the data multiple times
			Compare each of the copies of the data and see the difference
			But this can be very expensive
		Parity bits that act as a summary
			We can compare the data with the parity to see if something has changed
			Exteremly cheap as it can be done in a single transmission


**Detection of parities**

	We can detect parities by adding a single bit
	We can either do even or odd parity 

![[Pasted image 20231102101614.png]]

**Software parity

![[Pasted image 20231102101725.png]]

**Hardware parity

	Hardware is faster then software, this can be done using XOR gates on every bit (if it is an even number of bits), this outputs the parity result

![[Pasted image 20231102101855.png]]

**Burst errors**

	If multiplpe errors are to occur, then it probably will occur in bursts
		A collection of bits will all change, rather than singular random bits changing

	Parity may be able to solve some, but not for all
		If there is an even number of errors then the parity bit would be unchanged
		100 0001 will have the same parity as 101 0101

**Burst errors detection** 

![[Pasted image 20231102102253.png]]

**Burst errors, ECC**

	We can cpombine parity bits with a checksum column, therefore we can detect and corrrect single errors. We cannot correct certain combinations of errors, but we can detect them

![[Pasted image 20231102102523.png]]

**Hard Drives**

	HDDs contain a collection of ferromagnetic disks, to record data we magnetise certain pieces of data and we can move the arm into and away from disks to record in particular areas and disks are constantly spinning.

![[Pasted image 20231102102623.png]]

**Tracks and sectors**

	Each disk contains multiple tracks, and each track contains multiple sectors where they are seperated by a gap. Each sector contains a preamble, block of data, then ECC and preamble allows for synchornisation

![[Pasted image 20231102102718.png]]

**HDD's performance**

	Time to move arm to correct track, the maximum speed is 5ms and the consecutive tracks are below 1ms.

	Disks spin with constant angular velocity
		Depends on the rotational speed usually 5400, 7200 or 10800 RPM
		Half a rotation averages from 3ms to 6ms

	Sector read time -> Approx 0.013ms
	More sector for outer tracks, higher data density
	Formatting (includes preamble and ECC) reduces capacity by 15%

**Optical disks**

	Reads the difference between land and pits by comparing 2 laser signals.

![[Pasted image 20231102102901.png]]

**Optical disks, data encoding**

	8 bits mapped to 14 bit symbol
	Rules of the symbols:
		Always two 0's between 1's
		Max of ten 0's in succession
		Only 267 valeues fit the rule
		Can handle single bit errors

![[Pasted image 20231102103025.png]]

**Optical disks, performance**

	Can handle up to 2mm scratches worth of burst errors
	Data on makes up 28% of bits stored
	For a 1x drive around 200 to 530 RPM

