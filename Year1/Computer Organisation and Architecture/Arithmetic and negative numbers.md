**Biased form

	Biased form is referred to as two's complement biased form, shifts all values by subtracting a bias to a range that we want

	Biased formula:

$$(\displaystyle\sum_{i=0} ^{N-1} symbol_i \times 2^i) - B $$

	Where N is the number of columns, i is the index of position and symbol is the digit at position i
 
	B is calculated by 2^{N-1} where N is the amount of bits so 000 = 3 bits 2^{2} = 4
	
	Main idea here is that two's complement, binary or biased form is more accurate then sign of magnitude since sign of magintude has two 0's which reduces the range and possible outcomes
