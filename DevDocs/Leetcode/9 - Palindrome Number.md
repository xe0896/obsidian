Given an integer `x`, return `true` _if_ `x` _is a_ _**palindrome**_, and `false` otherwise.
***
This problem was really straightforward if you just turned the integer into a string, so not much was learnt here but the reversal of the reversal process and changing the for loop was interesting:
```java
public boolean isPalindrome(int x) {
	if (x < 0) {
		return false; // minus sign cant be palindrome
	}

	String lazyString = String.valueOf(x);
	String lazyReversed = "";
	
	for (int i = lazyString.length() - 1; i >= 0; i--) {
		lazyReversed = lazyReversed + lazyString.charAt(i); // creates new string, StringBuilder is better
	}
	
	if (lazyString.equals(lazyReversed)) { // doing == is comparing references
		return true;
	} else {
		return false;
	}
}
```

<span style="color:red">make it not convert to a string, some ideas could be  </span>
