Given a string `s`, return _the longest_ _palindromic_ _substring_ in `s`.
***
Initially I thought a sliding window could of been done here, but after some thinking it won't be effective as the condition for the sliding window is if a string `s` is a palindrome which is expensive to check for every substring encountered by the window.

Instead (after looking at some hints), a better solution would be to start with a `char` in the given string and use that as the center and we grow this to a string to make it become a potential palindrome if the two outer `char` values are the same.

I created two pointers `x,y` which will be used to check outwards from the `center`, there were two cases that I had to consider: Palindrome could have even or odd length. This was relevant since a `center` wont exist for an even length Palindrome. 

Let's first consider the odd case which is the easiest case, let `center = C`:

$$\begin{array}{ccccc}
    b & a & b & a & d \\
    C- 1  & C & C + 1 & &   \\
  \end{array}$$
  If `C-1 == C+1` then this is a valid palindrome and could be potentially bigger so we search further, this justifies the use of pointers `x,y` so we can increment them to search even further:
   $$\begin{array}{ccccc}
    b & a & b & a & d \\
    C- x  & C & C + y & &   \\
  \end{array}$$
   We are allowed to increment **both** since it can never be a valid palindrome assuming that earlier conditions wasn't true (even conditions). This means that when we store the longest palindrome substring in `s`, we will do this twice for both even and odd cases, allowing us to consider both cases.

To update our longest palindrome in `s`, we use the `substring(a,b)` function that uses our center `C` and compare it with our current longest one. I had some problems with indexing using the `substring(a,b)` as `a` is inclusive whereas `b` is exclusive meaning `a` will start at index `a` whereas `b` will end at `b-1`, this means that when we increment `x` and `y`, we will increment it one time to many to exit the while loop and since `b` is exclusive, it handles it for us but `a` is inclusive so we have to do `center - x + 1` since `x` is left from the center.

```java
public String longestPalindrome(String s) {
	String longestPalindrome;
	// we use 1 rather then 0 as 0 will always be true
	int x = 1; 
	int y = 1;
	for (center = 0; center < s.length(); center++) {
		while (center - x >= 0 && center + y < s.length() &&  s.charAt(center - x) == s.charAt(center-y)) { // checks to see center offsets arent out of bounds and if its a valid palindrome
			x++;
			y++;
		}
		if (s.substring(center - x + 1, center + y).length() > longestPalindrome.length()) {
			longestPalindrome = substring(center - x + 1, center + y); // ensures max palindrome it comes across is the 
		}
}
```

Next case to handle was when even palindromes show up, this was done by similar logic but a few tweaks with the indexing:

$$\begin{array}{ccccccc}
b & a & z & z & a & d \\ 
& C - x & C & C + 1 & C + y& \\
\end{array}$$
In the example above, `z` and `z` are seen as centers and we check if they are equal which they are which allows us to handle the even length handling, and we also have to ensure that `C+1` is not out of bounds.
```java
if (center < s.length() - 1 && s.charAt(center) == s.charAt(center + 1))
```

The substrings also changed, since the `center` is really at the first occurrence of `z` in the example above and since also in `substring(a,b)` `b` is exclusive, we only have to do `+1` in `b` for `substring(center - x + 1, center + y + 1`).

```java
// After handling the odd length case
x = 1;
y = 1;
if (center + 1 < s.length() && s.charAt(center) == s.charAt(center + 1) {
	while (center - x >= 0 && center - y + 1 < s.length() && s.charAt(center - x) == s.charAt(center - y + 1)) {
		x++;
		y++;
	}

	if (s.substring(center - x + 1, center + y + 1).length() > longestPalindrome.length()) {
		longestPalindrome = s.substring(center - x + 1, center - y + 1);
	}
}
```

This has led us to the following full correct solution:
```java
public String longestPalindrome(String s) {
	String longestPalindrome;
	int x = 1;
	int y = 1;
	for (int center = 0; center < s.length(); center++) {
		while(center - x >= 0 && center - y < s.length() && s.charAt(center-x) == s.charAt(center-y)) {
			x++;
			y++;
		}
		if (s.substring(center - x + 1, center - y).length() > longestPalindrome.length() {
			longestPalindrome = s.substring(center - x + 1, center - y);
		}
		if (center + 1 < s.length() && s.charAt(center) == s.charAt(center + 1)) {
			while (center - x >= 0 && center - y + 1 < s.length() && s.charAt(center - x) == s.charAt(center - y + 1) ) {
				x++;
				y++;
			}
		}
		if (s.substring(center - x + 1, center - y + 1).length() > longestPalindrome.length()) {
			longestPalindrome = s.substring(center - x + 1, center - y + 1);
		}
	}
	return longestPalindrome;
}
```

`x,y` is not necessary as we increment both at the same time, but it is easier to read the code. 
## Lessons learned

- Using substring and knowing that `substring(a,b)`, `a` is inclusive and `b` is exclusive
- Handle different cases using while loop
- Keep track of the longest string we encounter
