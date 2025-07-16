A phrase is a **palindrome** if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string `s`, return `true` _if it is a **palindrome**, or_ `false` _otherwise_.
***
There are different ways to think about this question, one way is to reverse the given string and iterate it over comparing it with the given string and checking if the non-alphanumeric characters are equal or not. 

A much more efficient way would be have two pointers `L,R` where `L` starts at `0` and `R` starts at `s.length()-1` and we ensure that we only compare alphanumeric characters by skipping non-alphanumeric by using `Character.isLetterOrDigit` on our pointers and then comparing them two using `Character.toLowerCase(c1) == Character.toLowerCase(c2)` as the question states we must convert them to lower case.

The real challenge behind this is how we manage our pointers and ensuring we do not have any index out of bound errors since our while loop will be conditioned on `L<=R` and since we are adjusting `L` and `R` inside our while loop we must ensure we do not violate this condition while inside it. 

This becomes notable when we are skipping non-alphanumeric characters and also after we skip them we must have a check of `L > R` as if we have skipped all non-alphanumeric and this condition is satisfied then we can return `true` as the midpoint of the string must of been full of non-alphanumeric and there was no other characters to compare one `L > R`:
```java
public boolean isPalindrome(String s) {
	int L = 0;
	int R = s.length() - 1;
	while(L <= R) {
		while (L <= R && !Character.isLetterOrDigit(s.charAt(L))) {
			L++;
		}
		while (L <= R && !Character.isLetterOrDigit(s.charAt(R))) {
			R--;
		}
			  
		if(L > R) {
			break;
		}
			  
		if(Character.toLowerCase(s.charAt(L)) != Character.toLowerCase(s.charAt(R))) {
			return false;
		}
		R--;
		L++;
	}
	return true;
}
```