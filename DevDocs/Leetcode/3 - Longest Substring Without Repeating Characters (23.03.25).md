Given a string `s`, find the length of the **longest** **substring** without duplicate characters.
***
For this problem, I've already received hints on the use of two pointers such that we can iterate through the string given easily by having a pointer `i` which acts as the main pointer and another pointer `j` which will start from `i` and locate any substrings until a duplicate is found.

The way I decided to check if a duplicate is found is by creating a function `exists(char a, String N)` which takes in a character and our answer string and iterates over it and checks to see if it finds `a` is in `N`. This could of been done more efficiently via some sort of hash-set but this seemed fine to do:

```java
public boolean exists(char a, String N) {
	for (int i = 0; i < N.length(); i++) {
		if (N.charAt(i) == a) {
			return true;
		}
	}
	return false;
}
```

To use the two pointers, a nested loop was made and initially I made it so the inner loop (for `j`) start at `0`, but it made sense to start at `i` since it wouldn't allow us to handle duplicate characters properly if we were bounded to start at `0` every time. 

Another issue was about how would we ensure that we get the maximum substring, since I was using a for loop, our operations were being done sequentially so it made sense to use `Math.max(maxLength, N.length())` to ensure that if we ever come across an `N.length() > maxLength` then we should assign this to `maxLength`.

This problem was fairly straightforward and the following correct answer was made:

```java
public int lengthOfLongestSubstring(String s) {
	int maxLength = 0;
	String N;

	for (int i = 0; i < s.length(); i++) {
		N = "";
		for (int j = i; j < s.length(); j++) {
			if (!exists(s.charAt(j), N)) {
				N = N + s.charAt(j);
				maxLength = Math.max(maxLength, N.length);
			} else {
				break;
			}
		}
	}
	return maxLength;
}
```

But initially it seemed like this wasn't to efficient in terms of the use of pointers and not other things such as `N = N + s.charAt(j)` is not efficient as it creates a new string every time so its best to use `StringBuilder`. In terms of how once we arrive at a duplicate character, we should restart at that duplicate character rather then incrementing `i` (i.e: `i = j`). This seemed to me as a correct approach but this won't be correct since a string such as: `abcdaefg` would reach up to `N = abcd` then stop as it has encountered a duplicate character `a`, then start at the second `a` and get `aefg`, when in reality the longest substring is `bcdaefg` but since we made `i = j` we don't consider the case where if we removed the first `a` we could of gotten a much larger substring rather then just removing `a` and a lot more other characters.

Extra notes: I was doing the `i = j` stuff but then didn't account for the above so I thought it was something to do with the pointers not pointing to the correct characters so I was messing around with `i = j - 1` which gave me extra tests passed but still not 100% but it was just that the small tests passed that reaped benefits from that `-1`, 


<span style="color:red">also i could make this more efficient using StringBuilder and hashing but maybe when you see this again or use a completely different logic using a sliding window</span>.

## Lessons learned

- Use pointers wisely like in problem 944
- If-statements can be long and confuse you so`Math.max()` was nice here
- How Java appending strings require StringBuilder
- Consider more edge cases since this required that
