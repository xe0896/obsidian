You are given a **large integer** represented as an integer array `digits`, where each `digits[i]` is the `ith` digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading `0`'s.

Increment the large integer by one and return _the resulting array of digits_.
***
This problem is simple as we basically do what we are told to do, the logic that we went for was that we have a variable `count` which counts the amount of `9`'s there are in the given array in a sequence at the end which tells us if we need to make a new array `[1,0,0..]` which in this case occurs if `count == digits.length` or if we need to increment some other digits since the other digits in sequence have `9`'s such as `[8,0,9,9]` to `[8,1,0,0]` or if we just need to increment the digits with no worries of `9's` such as `[8,0,1,0]` to `[8,0,1,1]`:
```java
public int[] plusOne(int[] digits) {
	int count = 0;
	if(digits[digits.length-1] == 9) {
		while(digits.length-count > 0 && digits[digits.length-1] == 9) {
			if(digits[digits.length-1] != 9) {
				break;
			} else {
				count++;
			}
		}
		if (digits.length == count) {
			int[] di = new int[count+1];
			for(int i = 0; i < di.length; i++) {
				di[i] = 0;
			}
			di[0] = 1;
			return di;
		}
		digits[digits.length-1-count] = digits[digits.length-1-count] + 1;
		for(int i = 0; i < digits.length-count; i++) {
			digits[i] = 0;
		}
		return digits;
		
	} else {
		digits[digits.length-1] = digits[digits.length-1] + 1;
		return digits;
	}
}
```

