Given two strings `needle` and `haystack`, return the index of the first occurrence of `needle` in `haystack`, or `-1` if `needle` is not part of `haystack`.
***
This problem has many solutions, one of which is a one-liner since it is basically a function from the `String` class that was designed for this exact problem:
```java
public int strStr(String haystack, String needle) {
	return haystack.indexOf(needle);
}
```
However, this solution is to trivial so we will do another solution, using a sliding window. A sliding window normally appears when we have a `String` (which in this case is `haystack`) and aim to find a specific characteristic that a substring of that `String` has, in this case we want this substring to be equal to `needle` and return the index of the first occurrence, which in this case in a sliding window would be the `L` (left) pointer. 

A sliding window solution for this is pretty simple but there are two ways you could attempt this solution where one of them is much more efficient then the other due to the attributes of this problem. When doing sliding window solutions you may attempt to try make it dynamic and grow/shrink in size but this only works if the condition that we have is expensive to verify, and in our case the condition would be `haystack.substring(left, right + 1)` which would create a `String` every time which takes a toll on speed/memory. Furthermore, we know the exact size the window would need to be for a solution which would be `needle.length()` so growing and shrinking wouldn't make to much sense.

The "bad" solution in this case would attempt at it being a dynamic window and then fall back on a static window which wouldn't make to much sense to do as for it to be dynamic it would call `.substring` a lot as the `left` pointer would be halted and would call `.substring` many times until we reach `needle.length()`:

```java
public int strStr(String haystack, String needle) {
	int left = 0;
	char start = needle.charAt(0);
	for(int right = 0; right < haystack.length(); right++) {
		if(haystack.substring(left, right + 1).equals(needle)) {
			return left;
		} else if (needle.length() < right - left + 2) {
			left++;
		} else if (haystack.charAt(left) != start) {
			left++;
		}
	}
	return -1;
}
```
`.substring(a,b)` has `b` to be exclusive hence the `+1` and we do `right - left + 2` since we incremented `right` before this condition could be `true` so we do `+2` to check the correct indexes due to our delayed check, we could remove this `+2` as well as make some optimisations since `haystack.substring(left, right + 1).equals(needle)` is being called every iteration but it would only be true if `needle.length() == right - left + 1`, and the `+1` relies on using `+1` on our `+2` ordeal and the way to not use `+2` is to not use an `else if` statement since it would increment `right` if it is `false` then once it is `true` it will trigger the condition but it is to late, we could also omit `start` since we do not to make a separate condition to check if `haystack.charAt(left) != start` since our `right - left + 1` will handle the incrementation of `left`:
```java
public int strStr(String haystack, String needle) {
	int left = 0;
	for(int right = 0; right < haystack.length(); right++) {
		if(right - left + 1 < needle.length()) {
			left++;
		}
		if (right - left + 1 == needle.length()) {
			if (haystack.substring(left, right + 1).equals(needle)) {
				return left;
			}
		}
	}
	return -1;
}
```
We could further optimise this by not shrinking at all which we discussed earlier on static vs dynamic since the main issue of this is that we do not care about the **longest**, we are just given the `needle` and find it in the `haystack` so static is always better then `dynamic` in sliding windows:
```java
public int strStr(String haystack, String needle) {
	int n = haystack.length();
	int m = needle.length();
	if (n == 1) {return -1;}
	for(int i = 0; i <= n - m; i++) {
		if(haystack.substring(i, i + m).equals(needle)) {
			return i;
		}
	}
	return -1;
}
```
We do `i <= n - m` as we want to also include the case where we are given a case such as `strStr("a", "a")`.

This is a static implementation and is much simpler and elegant then the rest and is still technically a sliding window but is not growing/shrinking since we already know the length of the window, it is not unknown like it would be in a ***longest*** type problem.

