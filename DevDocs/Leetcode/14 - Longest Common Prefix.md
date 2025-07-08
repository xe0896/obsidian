Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.
***
After realising that this isn't just a duplicate of the Longest Substring problem and prefixes are only concerned of the first characters of the string, this problem was straightforward. 

My first intuition was to assume that the prefix had an extra character so we have something to compare with and then terminate a loop (that would be comparing a character at an index `j`) once we find out that this extra character is not a common prefix.

A problem arises with this since this extra character depends on the minimum length string of the array since we can't assume an extra character if it is out of bounds, for this we can find out the minimum length string of the array and make that bound the outer loop as we cannot go beyond that index:
```java
public String longestCommonPrefix(String[] strs) {
	String sub = "";
	int minLength = 200; // Problems states that this is the max length
	for(int i = 0; i < strs.length; i++) {
		minLength = Math.min(strs[i].length(), minLength):
	}
```
As stated above, we assume the next character to be a valid character in the longest common prefix and then iterate through each string in the array and compare this with the assumption and if this is valid then we carry on until we reach the minimum length string of the array, if we find an inconsistency then we terminate the outer loop and remove our assumption from the output.
```java
outer:
for(int j = 0; j < minLength; j++) {
	String a = String.valueOf(strs[0].charAt(0));
	sub = sub + a;
	for(int i = 0; i < strs.length; i++) {
		if(strs[i].charAt(i) != sub.charAt(j)) {
			sub = sub.substring(0, sub.length() -1);
			break outer;
		}
	}
	return sub;
}
```
This all leads to our final solution:
```java
public String longestCommonPrefix(String[] strs) {
	String sub = "";
	int minLength = 200;
	for (int i = 0; i < strs.length; i++) {
		minLength = Math.min(strs[i].length(), minLength);
	}
	outer:
	for(int j = 0; j < minLength; j++) {
		String a = String.valueOf(strs[0].charAt(j));
		sub = sub + a;
		for(int i = 0; i < strs.length; i++) {
			if (strs[i].charAt(i) != sub.charAt(j)) {
				sub = sub.substring(0, sub.length() -1) {
				break outer;
			}
		}
	}
	return sub;
}
```
